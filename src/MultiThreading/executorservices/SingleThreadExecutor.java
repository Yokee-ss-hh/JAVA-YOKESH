package MultiThreading.executorservices;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadExecutor {
    // A thread pool with exactly one worker thread
    // All tasks are executed sequentially, in submission order, one task at a time
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future1 = executorService.submit(()-> "hello");
        System.out.println(future1.get());
        Future<String> future2 = executorService.submit(()-> "hi");
        System.out.println(future2.get());
        Future<String> future3 = executorService.submit(()-> "bye");
        System.out.println(future3.get());
        executorService.shutdown();
    }
}
