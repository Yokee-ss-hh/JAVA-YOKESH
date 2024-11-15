package org.dsa;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        // Executor is a interface which has a execute method which takes Runnable object
        Executor executor = Executors.newFixedThreadPool(5);
        executor.execute(()->{
            System.out.println("Hello");
        });
    }
}
