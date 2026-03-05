package MultiThreading.concurrentPackage;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    // A synchronization aid that allows a group of threads to wait for each other to reach a common barrier point.
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Runnable runnable = ()->{
            System.out.println(Thread.currentThread().getName()+" started execution");
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+" completed execution");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };

        Thread t1 = new Thread(runnable,"t1");
        Thread t2 = new Thread(runnable,"t2");
        Thread t3 = new Thread(runnable,"t3");
        t1.start();
        t2.start();
        t3.start();

        // All 3 threads waited for each other at await() method and after that only they moved to next executions.

        // Now what if CyclicBarrier(3) and we have 5 threads.
        Thread.sleep(3000);

        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(3);
        Runnable runnable1 = ()->{
            System.out.println(Thread.currentThread().getName()+" started execution");
            try {
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+" completed execution");
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };

        Thread t4 = new Thread(runnable1,"t4");
        Thread t5 = new Thread(runnable1,"t5");
        Thread t6 = new Thread(runnable1,"t6");
        Thread t7 = new Thread(runnable1,"t7");
        Thread t8 = new Thread(runnable1,"t8");
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        // First 3 threads gets a chance to wait near await() method as cyclic barrier allows only 3 to wait
        // After that all 3 moves to next execution and barrier resets to 0 as it is a cyclic barrier
        // The next 2 threads will wait near await() and keep on waiting infinitely for another thread which will never come
        // as we don't have one. so these 2 threads will never move to next execution point and JVM never quoits too as they all
        // waits infinitely.
        // So in the above example, 2 threads prints "started execution" and they never print "completed execution".
    }
}
