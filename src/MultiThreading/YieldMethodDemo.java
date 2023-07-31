package MultiThreading;

import java.lang.*;

public class YieldMethodDemo implements Runnable
{
    public void run()
    {
        System.out.println("Started " + Thread.currentThread());
        // calling yield() method on current thread to move it
        // back to ready state from running state
        Thread.yield();
        System.out.println("Ended " + Thread.currentThread());
    }
    public static void main (String[] args)
    {
        YieldMethodDemo y1 = new YieldMethodDemo();
        // creating first thread
        Thread t1 = new Thread(y1, "First child thread");

        YieldMethodDemo y2 = new YieldMethodDemo();
        // creating first thread
        Thread t2 = new Thread(y1, "Second child thread");

        // assigning priority to threads
        t1.setPriority(4);
        t2.setPriority(8);

        // calling thread will execute run() function
        t1.start();
        t2.start();
    }
    /*
    Here, the priority of thread t1 is 4, whereas the priority of the second thread t2 is 8. Because the second thread has the highest priority so thread selector executes it first.
    When the yield() method is called on thread t2, t2 returns to the Ready state. Now, the selector selects thread t1 for its execution.
    When yield() is called on t1 because t2 has the highest priority, so t2 executes again, and after its execution finishes, thread t1 resumes its execution. */
    // The same order might not come if we run multiple times, As The OS is free to ignore yield() calls.
}
