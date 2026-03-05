package MultiThreading.executorservices;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutdownVsShutdownNow {
    public static void main(String[] args) throws InterruptedException {
        // All the submitted tasks will continue to complete when shutdown() is called
        // executorService will not accept a new task upon shutdown()
        // JVM exits after this execution
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 3; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " started");
                try { Thread.sleep(3000); } catch (Exception e) {}
                System.out.println("Task " + taskId + " finished");
            });
        }
        executor.shutdown();
        System.out.println("Shutdown called");

        // executorService will not accept a new task upon shutdownNow()
        // All the submitted tasks will be interrupted when shutdownNow() is called
        // Removes waiting tasks from the queue
        // Returns list of tasks that never started
        ExecutorService executor1 = Executors.newFixedThreadPool(1);
        executor1.submit(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Running...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Task interrupted!");
            }
        });
        Thread.sleep(2000);
        List<Runnable> list = executor1.shutdownNow();
        System.out.println(list.size()); // 0 because the only task was already running
    }
}
