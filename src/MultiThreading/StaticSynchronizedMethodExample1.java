package MultiThreading;


class Dog{

    static int counter = 0;
    static synchronized void eat() {
        for (int i = 0; i < 10; i++) {
            System.out.println("I am eating -> " + Thread.currentThread().getName());
            counter += 1;
            System.out.println(Thread.currentThread().getName() + " -> increased counter"+"->"+counter);
        }
    }
    static void bark(){
        synchronized (Dog.class){
            for(int i=0;i<5;i++){
                System.out.println("Barking ->"+Thread.currentThread().getName());
            }
        }
    }
}
public class StaticSynchronizedMethodExample1 {

    // The intended purpose of static synchronized methods is when you want to allow
    // only one thread at a time to use some mutable state stored in static variables of a class.
    // In simple words a static synchronized method will lock the class instead of the object,
    // and it will lock the class because the keyword static means: "class instead of instance".
    // The keyword synchronized means that only one thread can access the method at a time.
    // And static synchronized mean ->
    // Only one thread can access the class at one time.
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                Dog.eat();
                Dog.bark();
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();
    }
    // The above code creates 2 threads which holds lock on class level for increasing counter which is a static data
    // First thread hold lock on the class and calls eat() method which increases counter from 0 to 10 and calls
    // bark() method which prints "Barking" 5 times. After this, First thread removes lock on class
    // Second thread acquires lock on class and calls eat() method which increases counter from 10 to 20 and calls
    // bark() method which prints "Barking" 5 times. After this, Second thread removes lock on class
}
