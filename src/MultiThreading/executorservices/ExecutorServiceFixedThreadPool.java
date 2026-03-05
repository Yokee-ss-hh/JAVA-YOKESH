package MultiThreading.executorservices;


import java.util.concurrent.*;

public class ExecutorServiceFixedThreadPool {
    // Fixed number of threads
    // tasks wait until threads are free
    // if there are 10 tasks, and we created FixedThreadPool of size 3
    // then 3 tasks runs at a time and 7 will wait
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Fixed number of threads, extra tasks goes to queue
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Runnable runnable1 = ()->{
            System.out.println("answered by runnable before 1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("answered by runnable after 1");
        };
        Runnable runnable2 = ()->{
            System.out.println("answered by runnable before 2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("answered by runnable after 2");
        };
        // execute() is only for runnable object and it returns nothing
        executorService.execute(runnable1);
        // submit() is for both runnable and callable, and it returns Future object
        // submit() returns Future for runnable even though runnable doesn't return anything because we can use that future object to cancel the task once we submit it etc ...
        Future<?> future1 = executorService.submit(runnable2);
        System.out.println(future1.isDone()); // non blocking call
        System.out.println(future1.get()); // blocking call
        Runnable runnable3 = ()->{
            System.out.println("answered by runnable before 3");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("answered by runnable after 3");
        };
        Future<?> future2 = executorService.submit(runnable3);
        System.out.println("Something is running by main thread");
        future2.cancel(true);
        // true means interrupt the thread if running
        // false means cancel the task if only not started
        Runnable runnable4 = ()->{
            System.out.println("answered by runnable before 4");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("answered by runnable after 4");
        };
        CompletableFuture<?> completableFuture = CompletableFuture.runAsync(runnable4,executorService);
        System.out.println(completableFuture.get());
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(()->100,executorService);
        completableFuture1.thenAccept(System.out::println);
        // Similarly we can use multiple methods supported by Function package etc...
        executorService.shutdown();
    }
}