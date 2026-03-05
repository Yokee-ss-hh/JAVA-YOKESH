package MultiThreading.concurrentPackage;

import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLock {
    private final ReentrantLock reentrantLock = new ReentrantLock(true);
    private final ReentrantLock reentrantLock1 = new ReentrantLock(true);
    private final ReentrantLock reentrantLock2 = new ReentrantLock(true);
    // if fair = true, the threads wait in FIFO order
    // if fair = false, its random to acquire locks
    public void doSomethingOne(String job){
        reentrantLock.lock();
        System.out.println("Doing "+job+" by "+Thread.currentThread().getName());
        doSomethingTwo("lm98");
        reentrantLock.unlock();
    }
    public void doSomethingTwo(String job){
        reentrantLock.lock();
        System.out.println("Doing "+job+" by "+Thread.currentThread().getName());
        System.out.println("There are "+reentrantLock.getHoldCount()+" locks held by "+Thread.currentThread().getName());
        System.out.println("Is there any threads waiting to hold lock ? "+reentrantLock.hasQueuedThreads());
        System.out.println("Whats the queue size as of this execution with waiting threads "+reentrantLock.getQueueLength());
        reentrantLock.unlock();
    }

    public void doSomethingThree() {
        // if I use just lock.lock() the threads waits in queue if they don't get a chance to acquire a lock
        // with tryLock() they won't wait in a queue to acquire a lock.
        if(reentrantLock1.tryLock()){
            System.out.println("Got Lock for "+Thread.currentThread().getName());
            reentrantLock1.unlock();
        }
        else{
            System.out.println("Didn't get lock "+Thread.currentThread().getName());
        }
    }

    public void doSomethingFour(){
        // in lock(), if lock is busy, the waiting threads just wait and ignore any interrupt
        // in lockInterruptibly(), if lock is busy, the waiting threads throws InterruptedException(), stops waiting and doesn't acquire the lock
        try{
            reentrantLock2.lockInterruptibly();
            System.out.println("Doing something :"+Thread.currentThread().getName());
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        finally {
            reentrantLock2.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReEntrantLock reEntrantLock = new ReEntrantLock();
        Thread t1 = new Thread(() -> reEntrantLock.doSomethingOne("xe12"), "T1");
        Thread t2 = new Thread(() -> reEntrantLock.doSomethingOne("xe12"), "T2");
        t1.start();
        t2.start();

        ReEntrantLock reEntrantLock1 = new ReEntrantLock();
        Thread t3 = new Thread(reEntrantLock1::doSomethingThree,"T3");
        t3.start();
        Thread t4 = new Thread(reEntrantLock1::doSomethingThree,"T4");
        t4.start();

        ReEntrantLock reEntrantLock2 = new ReEntrantLock();
        Thread t5 = new Thread(reEntrantLock2::doSomethingFour,"T5");
        t5.start();
        Thread.sleep(3000); // Let's sleep the main thread so that t5 gets to start first before t6 starts. so that we can interrupt t6
        Thread t6 = new Thread(reEntrantLock2::doSomethingFour,"T6");
        t6.start();
        t6.interrupt();
    }
}
