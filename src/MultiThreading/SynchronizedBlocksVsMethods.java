package MultiThreading;

class Sync{
    synchronized void syncMethod(){
        for(int i=0;i<10;i++){
            System.out.println("Sync Method -> "+ Thread.currentThread().getName());
        }
    }
    void syncBlock(){
        synchronized (this){
            for(int i=0;i<10;i++){
                System.out.println("Sync Block -> "+Thread.currentThread().getName());
            }
        }
    }
}
public class SynchronizedBlocksVsMethods {
    /*
    By functionality synchronized blocks are equivalent to synchronized method
    1)
    synchronized public void method1() {
        // do something
    }

is equal to
   2)
   public void method1() {
           synchronized(this){
                  // do something
           }
    }

    In both ways, The lock is held on calling object.
     */
    public static void main(String[] args) {
        Sync s = new Sync();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                s.syncMethod();
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                s.syncBlock();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.setName("method thread");
        t2.setName("block thread");
        t1.start();
        t2.start();
    }
    // t1 with name "method thread" calls synchronized method on object "s" of class "Sync"
    // Similarly, t2 with name "block thread" calls synchronized block on object "s" of class "Sync"
    // As In both cases both threads holds lock on "s" object
    // So, OS will allow only 1 thread to hold lock on object "s" at any time and another thread will
    // wait till the other thread completes all of its execution
    // So, Finally There is no difference b/w synchronized block and synchronized method in terms
    // of functionality.
}
