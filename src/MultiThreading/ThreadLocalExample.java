package MultiThreading;

public class ThreadLocalExample {
    int count=0;
    static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->0);
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        Thread t1 = new Thread(()->{
           for(int i=0;i<100000;i++){
               threadLocalExample.count++;
           }
        });
        Thread t2 = new Thread(()->{
            for(int i=0;i<100000;i++){
                threadLocalExample.count++;
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(2000); // force the main thread not to print below line
        System.out.println(threadLocalExample.count); // should print 200000 but it prints some random shit

        Thread.sleep(2000);
        Thread t3 = new Thread(()->{
            for(int i=0;i<100000;i++){
                ThreadLocalExample.threadLocal.set(ThreadLocalExample.threadLocal.get()+1);
            }
            System.out.println(ThreadLocalExample.threadLocal.get()); // 100000 -> As it incremented its own thread local variable
        });
        Thread t4 = new Thread(()->{
            for(int i=0;i<100000;i++){
                ThreadLocalExample.threadLocal.set(ThreadLocalExample.threadLocal.get()+1);
            }
            System.out.println(ThreadLocalExample.threadLocal.get()); // 100000 -> As it incremented its own thread local variable
        });
        t3.start();
        t4.start();
        Thread.sleep(2000);
        System.out.println(ThreadLocalExample.threadLocal.get()); // prints 0 as main thread did no increment operations so 0 is its default value

        // ThreadLocal does NOT store values inside itself.
        // Instead, each Thread object has an internal field called "threadLocals" (ThreadLocalMap).
        //
        // When a thread calls threadLocal.set(value):
        // - It stores the value inside its own threadLocals map.
        // - The ThreadLocal object acts only as a key.
        //
        // If ThreadLocal is static:
        // - There is only one ThreadLocal key shared by all instances.
        // - Each thread still stores its own value in its own map.
        //
        // If ThreadLocal is non-static:
        // - Each object has its own ThreadLocal key.
        // - Each thread still stores values in its own map.
        // - A single thread may have multiple entries (one per ThreadLocal key).
        //
        // Isolation is achieved because storage lives inside the Thread,
        // not inside the ThreadLocal object.
    }
}
