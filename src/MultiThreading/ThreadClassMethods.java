package MultiThreading;

public class ThreadClassMethods {
    public static void main(String[] args) {
        System.out.println(Thread.MIN_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);
        System.out.println(Thread.MAX_PRIORITY);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
        ThreadGroup tg = new ThreadGroup("yokesh");
        // We can use another constructor of ThreadGroup
        // new ThreadGroup(ThreadGroup Parent, name) This creates child thread group under parent thread group
        Thread t = new Thread(tg,r);
        System.out.println(t.getThreadGroup());
        // we can suspend, resume or interrupt a group of threads by a single method call.
        // NOTE: suspend(), resume() and stop() methods are deprecated
        System.out.println(t.isAlive()); // false as thread has not started yet
        t.start();
        System.out.println(t.isAlive()); // true
        System.out.println(t.getName());
        System.out.println(t.getId()); // Unique ID is created when thread is started and destroyed when
        // thread is dead
        System.out.println(t.getClass());
        System.out.println(Thread.activeCount()); // Returns threads count in current ThreadGroup by iterating
        // in parent TreadGroup as well as child ThreadGroup. The count may not be the exact due to threads can
        // be dynamically create/destroy.
    }
}
