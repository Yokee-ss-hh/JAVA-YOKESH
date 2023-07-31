package MultiThreading;

class CounterDemo{
    static int counter = 0;

    static String name = "a";
    static synchronized void m1() {
        for (int i = 0; i < 5; i++) {
            System.out.println(counter + "->" + Thread.currentThread().getName());
            counter += 1;
        }
    }
    static void m2() {
        synchronized (CounterDemo.class) {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + "->" + Thread.currentThread().getName());
                name += "a";
            }
        }
    }
}
public class StaticSynchronizedMethodExample2 {
    // Suppose there are multiple static synchronized methods (m1, m2, m3, m4) in a class, and suppose one
    // thread is accessing m1, then no other thread at the same time can access any other static synchronized methods.
    public static void main(String[] args) {
        Thread t1 = new Thread(){
          public void run(){
              CounterDemo.m1();
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                CounterDemo.m2();
            }
        };
        t1.start();
        t2.start();
    }
    // There are 2 threads 1 accessing static method and another accessing static block
    // If thread 1 starts execution it holds lock on entire class, and it will not allow thread 2 to access the
    // static block inside the class
    // That means if there are multiple static synchronized methods/blocks and thread1 access 1 static method/block
    // and thread2 access different method/block (other than the method/block accessed by thread1). Then, Thread 2
    // cannot execute the static method/block until thread1 releases lock on the class.
 }
