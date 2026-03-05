package MultiThreading.concurrentPackage;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerWithAndWithout {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int value=0;
    public void increment(){
        for(int i=0;i<100000;i++){
            value++;
        }
    }
    public void incrementViaAI(){
        for(int i=0;i<100000;i++){
            atomicInteger.incrementAndGet();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerWithAndWithout atomicIntegerWithAndWithout = new AtomicIntegerWithAndWithout();
        Thread t1 = new Thread(atomicIntegerWithAndWithout::increment);
        Thread t2 = new Thread(atomicIntegerWithAndWithout::increment);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(atomicIntegerWithAndWithout.value);

        AtomicIntegerWithAndWithout atomicIntegerWithAndWithout1 = new AtomicIntegerWithAndWithout();
        Thread t3 = new Thread(atomicIntegerWithAndWithout1::incrementViaAI);
        Thread t4 = new Thread(atomicIntegerWithAndWithout1::incrementViaAI);
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        System.out.println(atomicIntegerWithAndWithout1.atomicInteger.get());
    }
}
