package leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;
import java.util.function.IntConsumer;

public class Solution1116 { // ZeroEvenOdd

    private final int n;
    private final Lock lock = new ReentrantLock();
    private final Condition zeroCondition = lock.newCondition();
    private final Condition numbCondition = lock.newCondition();
    private volatile boolean zeroTime = true;
    private final AtomicInteger curr = new AtomicInteger(1);

    public Solution1116(int n) {    // ZeroEvenOdd Constructor
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (curr.get() <= n) { // Ensure we print zero until we reach n
            try {
                lock.lock(); // Lock to ensure mutual exclusion
                while (!zeroTime) {     // Wait until it's zero's turn
                    zeroCondition.await();
                }
                if (curr.get() <= n) {      // Check if we haven't exceeded n
                    printNumber.accept(0);
                }

                zeroTime = false;
                numbCondition.signalAll(); // Notify even/odd threads that zero has printed
            } finally {
                lock.unlock();          // Unlock to allow other threads to proceed
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (curr.get() < n) {    // Ensure we print even numbers until we reach n
            try {
                lock.lock();
                while (zeroTime || curr.get() % 2 != 0) {   // Wait until it's even's turn
                    numbCondition.await();          // Wait for zero to print or for an odd number to be printed
                }

                if (curr.get() <= n) {  // Check if we haven't exceeded n
                    printNumber.accept(curr.get());
                }

                curr.getAndIncrement();     // Increment the current number
                zeroTime = true;
                zeroCondition.signal();     // Notify zero thread that an even number has been printed
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (curr.get() <= n) {
            try {
                lock.lock();
                while (zeroTime || curr.get() % 2 == 0) {   // Wait until it's odd's turn
                    numbCondition.await();
                }

                if (curr.get() <= n) {      // Check if we haven't exceeded n
                    printNumber.accept(curr.get());
                }
                curr.getAndIncrement();
                zeroTime = true;
                zeroCondition.signal();     // Notify zero thread that an odd number has been printed
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        Solution1116 zeo = new Solution1116(5);
        IntConsumer printer = System.out::print;

        Thread t1 = new Thread(() -> {  // Zero thread
            try {
                zeo.zero(printer);  // Print zero
            } catch (InterruptedException e) {  // Handle interruption
                Thread.currentThread().interrupt();     // Restore the interrupted status
            }
        });

        Thread t2 = new Thread(() -> {  // Even thread
            try {
                zeo.even(printer);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t3 = new Thread(() -> {  // Odd thread
            try {
                zeo.odd(printer);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start(); // Start the zero thread
        t2.start(); // Start the even thread
        t3.start(); // Start the odd thread
    }
}