package MultiThreading.concurrentPackage;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    // semaphore controls how many threads can access a resource at a time
    private static final Semaphore semaphore = new Semaphore(2);
    // semaphore is made static bcs no matter how many instances of this class are created
    // semaphore allows only 2 threads to access useResource() method
    private final String name;
    public SemaphoreExample(String name) {
        this.name = name;
    }
    public void useResource() {
        try {
            System.out.println(Thread.currentThread().getName() +
                    " trying to access " + name);

            semaphore.acquire();

            System.out.println(Thread.currentThread().getName() +
                    " acquired permit for " + name);

            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName() +
                    " finished work on " + name);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
    public static void main(String[] args) {
        SemaphoreExample semaphoreExample = new SemaphoreExample("postgresdb");
        SemaphoreExample semaphoreExample1 = new SemaphoreExample("oracledb");
        SemaphoreExample semaphoreExample2 = new SemaphoreExample("verticadb");
        Runnable task1 = semaphoreExample::useResource;
        Runnable task2 = semaphoreExample1::useResource;
        Runnable task3 = semaphoreExample2::useResource;


        new Thread(task1, "Thread-1").start();
        new Thread(task2, "Thread-2").start();
        new Thread(task3, "Thread-3").start();
        new Thread(task1, "Thread-4").start();
        new Thread(task2, "Thread-5").start();
        new Thread(task3, "Thread-6").start();
    }
}
