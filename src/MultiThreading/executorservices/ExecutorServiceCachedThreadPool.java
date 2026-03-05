package MultiThreading.executorservices;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCachedThreadPool {
    // No pool size is given
    // if we submit 10 tasks it creates 10 threads to execute them
    // if we again submit another 10, it sees if any previously threads which ran 10 tasks are idle, if yes, it re-uses
    // if they are still running, it creates another 10, so it continues like that forever so long as tasks are coming
    // it is like create a new thread if the previously created threads are idle
    // NOTE: the idle threads die in 60 seconds
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future = executorService.submit(()->10);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
