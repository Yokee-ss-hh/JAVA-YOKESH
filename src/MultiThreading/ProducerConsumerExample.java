package MultiThreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

class RandomStringsGenerator{
    public static String generateRandomString(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
class Inventory{
    static Queue<String> inventoryQueue = new ArrayDeque<>();
    public void supplier(){
        synchronized (inventoryQueue){
            System.out.println(Thread.currentThread().getName()+"->"+"Invoked");
            String addedInventoryName = RandomStringsGenerator.generateRandomString();
            inventoryQueue.add(addedInventoryName);
            System.out.println("A new goods is added to inventory"+"->"+addedInventoryName);
            inventoryQueue.notify();
            System.out.println(Thread.currentThread().getName()+"->"+"Exited");
        }
    }
    public void consumer(){
        synchronized (inventoryQueue){
            System.out.println(Thread.currentThread().getName()+"->"+"Invoked");
            if(inventoryQueue.isEmpty()){
                try{
                    inventoryQueue.wait();
                }
                catch (InterruptedException IE){
                    System.out.println("Some exception occurred with message as :"+IE.toString());
                }
            }
            System.out.println(inventoryQueue);
            System.out.println(Thread.currentThread().getName()+"->"+"Exited");
        }
    }
}
public class ProducerConsumerExample {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Runnable R1 = new Runnable() {
            @Override
            public void run() {
                inventory.consumer();
            }
        };
        Runnable R2 = new Runnable() {
            @Override
            public void run() {
                inventory.supplier();
            }
        };

        Thread consumerThread = new Thread(R1);
        Thread supplierThread = new Thread(R2);

        consumerThread.start();
        supplierThread.start();
    }
}
