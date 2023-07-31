package MultiThreading;
// There are 3 variations of interrupt methods
// 1) public void interrupt()
// 2) public boolean isInterrupted()
// 3) public static boolean interrupted() -> Calls isInterrupted() method internally
/*
The interrupt mechanism is implemented using an internal flag known as the interrupt status.
Invoking Thread.interrupt() sets this flag. When a thread checks for an interrupt by invoking
the static method Thread.interrupted(), interrupt status is cleared.
The non-static isInterrupted() method, which is used by one thread to query the interrupt
status of another, does not change the interrupt status flag.
By convention, any method that exits by throwing an InterruptedException clears interrupt status
when it does so. However, it's always possible that interrupt status will immediately be
set again, by another thread invoking interrupt.
 */
// StackOverFlow Link: https://stackoverflow.com/questions/43941832/java-thread-interrupted-and-interruption-flag
public class InterruptMethod {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Entered method by: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                    System.out.println("Thread: " + Thread.currentThread().getName() + " " + "is interrupted");
                }
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
        t1.interrupt();
        System.out.println(t1.isInterrupted());
        System.out.println("I will be executed by main thread :"+Thread.currentThread().getName());
        System.out.println(t1.isAlive());
    }
}
