package org.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    static class Helper{
        private Queue<Integer> queue = new LinkedList<>();
        private int maxCapacity;
        private int limit;
        public Helper(int maxCapacity, int limit) throws InterruptedException {
            this.maxCapacity=maxCapacity;
            this.limit=limit;
        }
        public void producer() throws InterruptedException{
            int value=0;
            while(value<limit){
                synchronized(queue){
                    while(queue.size()==maxCapacity){
                        queue.wait();
                    }
                    System.out.println("Produced"+value);
                    queue.add(value++);
                    queue.notify();
                }
            }
        }
        public void consumer() throws InterruptedException {
            while(true){
                synchronized(queue){
                    while(queue.isEmpty()){
                        queue.wait();
                    }
                    System.out.println("Consumed"+queue.peek());
                    System.out.println(queue.poll());
                    queue.notify();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Helper helper = new Helper(3,10);
        Thread t1 = new Thread(()->{
            try {
                helper.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(()->{
            try {
                helper.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
