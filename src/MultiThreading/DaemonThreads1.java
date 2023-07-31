package MultiThreading;

public class DaemonThreads1 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am the run() method which will be called thread");
            }
        };
        Thread t = new Thread(r);
        System.out.println(Thread.currentThread().isDaemon()); // Checking main thread is daemon or not
        System.out.println(t.isDaemon()); // false
        t.setDaemon(true);
        System.out.println(t.isDaemon()); // true
        t.start();
        // t.setDaemon(true); Uncommenting this line throws IllegalThreadStateException as we are setting
        // already started thread as Daemon
    }
}
