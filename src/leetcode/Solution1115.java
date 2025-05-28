package leetcode;

import java.util.concurrent.Semaphore;

public class Solution1115 { // FooBar

    private final int n;
    private final Semaphore fooSemaphore = new Semaphore(1);
    private final Semaphore barSemaphore = new Semaphore(0);

    public Solution1115(int n) { // FooBar Constructor
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {   // Foo method
            fooSemaphore.acquire(); // Acquire semaphore for foo
            printFoo.run(); // Print "foo"
            barSemaphore.release(); // Release semaphore for bar
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {   // Bar method
            barSemaphore.acquire();
            printBar.run();
            fooSemaphore.release();
        }
    }

    public static void main(String[] args) {
        Solution1115 fooBar = new Solution1115(5);
        Thread thread1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));  // Print "foo"
            } catch (InterruptedException e) {
                e.printStackTrace();    // Handle interruption
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));  // Print "bar"
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();    // Start foo thread
        thread2.start();    // Start bar thread
    }
}
