package MultiThreading;

public class DaemonThreads2 {
    // As we know If all the non daemon threads completes their executions, Then Daemon threads irrespective
    // of their status (wait, runnable, running....) will be terminated by JVM and moved to dead.
    // Here main thread is "Non-Daemon" and "t" is Daemon
    // If main thread gets a chance first to execute System.out.println("Main Thread -> Non Daemon"); before
    // the "t" thread. Then we can see that even though "t" thread has some execution pending JVM terminates
    // "t" thread and code inside run() method will not be executed.
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10;i++){
                    System.out.println("Daemon Thread");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
        System.out.println("Main Thread -> Non Daemon");
        // In above example, As soon as main thread execution is completed which is non daemon
        // The daemon thread will not run the for loop 10 times inside the run() method. JVM stops the daemon
        // thread execution and move it to Dead state immediately as none of the non daemon threads
        // are in running state.
    }
}
