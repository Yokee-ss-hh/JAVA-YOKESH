package MultiThreading;
// Thread using interrupt without sleep() method in run() method
// Then, interrupt() will be ignored by JVM but, interrupt flag is set to true
public class InterruptMethod1 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside run method of thread");
                boolean b = Thread.interrupted();
                // 'b' -> Here Thread.interrupted() sets existing flag which has status as "true" to "false"
                // and returns past value which is "true" which is stored in "b"
                System.out.println(b);
                boolean b1 = Thread.interrupted();
                System.out.println(b1);
                // As of now, As interrupt status is "false" already, Until interrupt() is called, It will not
                // be set to "true". So Thread.interrupted() returns "false" and will be "false" status only
                // until "interrupt()" is called again
                boolean b2 = Thread.interrupted();
                System.out.println(b2);
                // As of now, As interrupt status is "false" already, Until interrupt() is called, It will not
                // be set to "true". So Thread.interrupted() returns "false" and will be "false" status only
                // until "interrupt()" is called again
            }
        };
        Thread t = new Thread(r);
        t.start();
        t.interrupt();
    }
}
