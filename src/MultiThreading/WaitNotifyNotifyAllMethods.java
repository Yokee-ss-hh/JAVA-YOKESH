package MultiThreading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class WaitNotifyNotifyAllMethods {

    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                synchronized (queue){
                    System.out.println(Thread.currentThread().getName()+"is invoked");
                    int temp = new Random().nextInt(1000);
                    queue.add(temp);
                    queue.notify();
                    System.out.println(String.format("New data %d is added to the queue",temp));
                }
                System.out.println(Thread.currentThread().getName()+"is dead");
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                synchronized (queue){
                    System.out.println(Thread.currentThread().getName()+"is invoked");
                    if(queue.isEmpty()){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println(e.toString());
                        }
                    }
                    else{
                        System.out.println(queue);
                    }
                }
                System.out.println(Thread.currentThread().getName() +"is dead");
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
    // OUTPUT:
    // Thread-0is invoked
    // New data 511 is added to the queue
    // Thread-0is dead
    // Thread-1is invoked
    // [511]
    // Thread-1is dead

    // Important Note:
    // A thread called object.wait() will go to wait state immediately by giving up the lock on the object
    // But, A thread called object.notify() will / will not give up the lock on the object depending on the
    // below 2 states
    // If object.notify() is the last line executed by the thread, Then thread will give up the
    // lock on the object
    // If object.notify() is in the middle of the method/block and if thread gives up the lock, Then What if
    // it needs the object for performing some operation in the later lines of the program. See below example
    /*
    Synchronized(some object){
      ----------- some 1000 lines
      Object.notify();
      ---------- some 1000 lines where the object is used for some operation
    }
     */
    // If object.notify() releases lock on object, Then It cannot use that object in the next 1000 lines for
    // some operation. So, The thread will not give up lock on the object even after object.notify() if
    // some lines are there after object.notify() call.
    // Until object.notify() is executed, The thread which called object.wait() will be in waiting (lets say
    // wait state 1)
    // When object.notify() is called, The notification goes to object.wait() and it enters into second waiting
    // state (Lets say wait state 2) because, the thread which executed object.notify() didn't give up the
    // lock on the object immediately. Until the thread gives up lock, the wait() called thread will be in
    // wait state 2.
    // After the thread which called notify() gave up lock on object, Then thread which called wait() will go from
    // wait state 2 to running state.
}
