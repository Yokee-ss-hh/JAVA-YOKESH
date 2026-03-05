package MultiThreading.concurrentPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteReEntrantLock {

    private static final Map<String, String> map = new HashMap<>();
    private static final ReentrantReadWriteLock lock =
            new ReentrantReadWriteLock(true); // fair mode

    // WRITE
    public void insertKey(String key, String value) {
        lock.writeLock().lock();
        try {
            System.out.println("START WRITE -> " + key +
                    " by " + Thread.currentThread().getName());

            map.put(key, value);

            Thread.sleep(800); // simulate heavy write
            // Here the thread don't release the lock, but it gives cpu to other waiting threads to execute
            // if the waiting thread is write thread then it cant come inside this method as the executing
            // thread is a write thread.

            System.out.println("END WRITE   -> " + key +
                    " by " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.writeLock().unlock();
        }
    }

    // READ
    public void readKey(String key) {
        lock.readLock().lock();
        try {
            System.out.println("READ -> " + key +
                    " = " + map.get(key) +
                    " by " + Thread.currentThread().getName());

            Thread.sleep(400); // simulate read delay
            // Here the thread don't release the lock, but it gives cpu to other waiting threads to execute
            // if the waiting thread is read thread then it cant come inside this method as the executing
            // thread is a read thread.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReadWriteReEntrantLock cache = new ReadWriteReEntrantLock();

        // Writer A
        Runnable writerA = () -> {
            for (int i = 0; i < 5; i++) {
                cache.insertKey("A" + i, "ValueA" + i);
            }
        };

        // Writer B
        Runnable writerB = () -> {
            for (int i = 0; i < 5; i++) {
                cache.insertKey("B" + i, "ValueB" + i);
            }
        };

        // Readers
        Runnable reader = () -> {
            for (int i = 0; i < 5; i++) {
                cache.readKey("A" + i);
                cache.readKey("B" + i);
            }
        };

        Thread writeThread1 = new Thread(writerA, "Writer-1");
        Thread writeThread2 = new Thread(writerB, "Writer-2");

        Thread readThread1 = new Thread(reader, "Reader-1");
        Thread readThread2 = new Thread(reader, "Reader-2");

        writeThread1.start();
        writeThread2.start();
        Thread.sleep(10); // very small delay in starting read threads so that writes happen for sometime
        // and sleep in writing and reading in the map so that other threads gets time
        // note that sleep doesn't release the locks holding by the threads
        readThread1.start();
        readThread2.start();
    }
}