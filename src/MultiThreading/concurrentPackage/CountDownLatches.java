package MultiThreading.concurrentPackage;

import java.util.concurrent.CountDownLatch;

public class CountDownLatches {
    // CountDownLatch allows one thread to wait for multiple threads and is one-time use.
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        // here 3 says how many threads decrement by 1
        // when it becomes 0 await() gives up
        // await() is blocking method.
        Runnable runnable = ()->{
            System.out.println("Thread "+Thread.currentThread().getName()+" is doing something");
            countDownLatch.countDown();
        };
        Thread thread1 = new Thread(runnable,"t1");
        Thread thread2 = new Thread(runnable,"t2");
        Thread thread3 = new Thread(runnable,"t3");
        thread1.start();
        thread2.start();
        thread3.start();
        // Let's make main thread to wait until all 3 threads complete their execution using latch
        // we can do the same using join() for all threads too
        countDownLatch.await();
        System.out.println("Hey ! I am printed by "+Thread.currentThread().getName() + " thread");
        // In the same example, if I place countDownLatch.await() after thread1 start()
        // thread1 makes latch count to 2, then main thread encounters await() it checks whats the count, it is 2
        // so it will wait forever until count is 0 as await() is blocking method. its kind of deadlock scenario.
    }
}
