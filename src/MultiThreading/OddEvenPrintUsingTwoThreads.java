package org.dsa;

public class OddEvenPrintUsingTwoThreads {
    static final Object object = new Object();
    private static int counter=1;
    private static int limit=10;
    static class Helper{
        public void printOdd() throws InterruptedException {
            while(counter<=limit){
                synchronized(object) {
                   if(counter % 2 == 1){
                       System.out.println("odd thread"+counter++);
                       object.notify();
                   }
                   else{
                       object.wait();
                   }
                }
            }
        }
        public void printEven() throws InterruptedException {
            while(counter<=limit){
                synchronized(object) {
                    if(counter % 2 == 0){
                        System.out.println("even thread"+counter++);
                        object.notify();
                    }
                    else{
                        object.wait();
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Helper helper = new Helper();
        Thread t1 = new Thread(()->{
            try {
                helper.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(()->{
            try {
                helper.printEven();
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
