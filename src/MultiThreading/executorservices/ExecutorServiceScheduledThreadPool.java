package MultiThreading.executorservices;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        // schedule(task,initialDelay,timeUnit)
        // run after 3 seconds and stop
        executorService.schedule(()-> System.out.println("running"),3, TimeUnit.SECONDS);
        // scheduleWithFixedDelay(task,initialDelay,period,timeUnit)
        // run after initial delay of 3 seconds, task again starts after a delay of 3 seconds even if the task completes before that period
        // Case 1: 12:00 task submitted, task started at 12:03, task completed at 12:04 but task again starts at 12:07
        // Case 2: 12:00 task submitted, task started at 12:03, task completed at 12:07, as period is crossed, the task again starts immediately at 12:08 as task took more time
        executorService.scheduleAtFixedRate(()-> System.out.println("shouting"),3,3,TimeUnit.SECONDS);
        // scheduleWithFixedDelay(task,initialDelay,period,timeUnit)
        // run after a delay of 3 seconds, task again starts after a delay of 3 seconds
        // It doesn't matter when task completes, after that it waits for some delay and then re-start the task
        // Case 1: 12:00 task submitted, task started at 12:03, task completed at 12:04 but task again starts at 12:07
        // Case 2: 12:00 task submitted, task started at 12:03, task completed at 12:07, even though task took more time, it waits for 3 seconds and task re-start at 12:10
        // Strict follow of delay after task finishes
        executorService.scheduleWithFixedDelay(()-> System.out.println("shouting"),3,3,TimeUnit.SECONDS);
        executorService.shutdown();
        // If there are more tasks than the pool size, the new tasks will wait in the queue
    }
}
