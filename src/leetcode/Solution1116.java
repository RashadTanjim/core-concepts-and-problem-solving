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
        while (curr.get() <= n) {
            try {
                lock.lock();
                while (!zeroTime) {
                    zeroCondition.await();
                }
                if (curr.get() <= n) {
                    printNumber.accept(0);
                }

                zeroTime = false;
                numbCondition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (curr.get() < n) {
            try {
                lock.lock();
                while (zeroTime || curr.get() % 2 != 0) {
                    numbCondition.await();
                }

                if (curr.get() <= n) {
                    printNumber.accept(curr.get());
                }


                curr.getAndIncrement();
                zeroTime = true;
                zeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (curr.get() <= n) {
            try {
                lock.lock();
                while (zeroTime || curr.get() % 2 == 0) {
                    numbCondition.await();
                }

                if (curr.get() <= n) {
                    printNumber.accept(curr.get());
                }
                curr.getAndIncrement();
                zeroTime = true;
                zeroCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        Solution1116 zeo = new Solution1116(5);
        IntConsumer printer = System.out::print;

        Thread t1 = new Thread(() -> {
            try {
                zeo.zero(printer);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                zeo.even(printer);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                zeo.odd(printer);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}