package org.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // ExecutorService is a sub-interface of Executor which has few more methods like
        // submit(), invokeAll(), invokeAny(), shutdown()

        // ------------- submit() -------------
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(()->{
            System.out.println("Hello Yokesh");
        });

        Future<String> result = executorService.submit(()-> "Hello Yokesh");
        if(result.isDone()){
            System.out.println(result.get());
        }

        // ------------ invokeAll() ---------------
        // All the threads will be blocked till all the callables are executed
        ExecutorService executorService1 = Executors.newFixedThreadPool(6);
        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(()->1);
        callables.add(()->2);
        callables.add(()->3);
        callables.add(()->4);
        List<Future<Integer>> results = executorService1.invokeAll(callables);
        for(Future<Integer> f: results){
            if(f.isDone()){
                System.out.println(f.get());
            }
        }

        // ------------- invokeAny() --------------
        // All the threads will not wait till all the callables are executed
        // invokeAny waits for atleast one task to get completed
        ExecutorService executorService2 = Executors.newFixedThreadPool(6);
        List<Callable<Integer>> callables1 = new ArrayList<>();
        callables1.add(()->11);
        callables1.add(()->12);
        callables1.add(()->13);
        callables1.add(()->14);
        Integer results1 = executorService2.invokeAny(callables1);
        System.out.println(results1);
    }
}
