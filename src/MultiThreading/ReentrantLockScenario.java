package MultiThreading;


public class ReentrantLockScenario {
    public synchronized void doSomethingOne(){
        System.out.println("Doing Something One"+"->"+Thread.currentThread().getName());
        doSomethingTwo();
    }
    public synchronized void doSomethingTwo(){
        System.out.println("Doing Something Two"+"->"+Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        ReentrantLockScenario reentrantLockScenario = new ReentrantLockScenario();
        Runnable r1 = reentrantLockScenario::doSomethingOne;
        Runnable r2 = reentrantLockScenario::doSomethingOne;
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
