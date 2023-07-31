package MultiThreading;

public class DeadLock {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        Thread t1 = new Thread(){
            public void run(){
                synchronized (object1){
                    System.out.println("Thread t1 holding lock on object1");
                    synchronized (object2){
                        System.out.println("Thread t1 holding lock on both object1 and object2");
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                synchronized (object2){
                    System.out.println("Thread t1 holding lock on object2");
                    synchronized (object1){
                        System.out.println("Thread t1 holding lock on both object1 and object2");
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
