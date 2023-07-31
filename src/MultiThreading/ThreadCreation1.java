package MultiThreading;

class ThreadImpl extends Thread{
    public void run(){
        System.out.println("I am running by new thread "+Thread.currentThread().getName());
    }
}

class ThreadEmptyImpl extends Thread{

}
public class ThreadCreation1 {
    public static void main(String[] args) {
        // As of now only main thread is there
        ThreadImpl t1 = new ThreadImpl();
        // main thread created child thread named "t1", So Here 2 threads are there, "main" and "t1"
        t1.start(); // This calls run() method in "ThreadImpl" class
        System.out.println("I am executed by main thread: "+Thread.currentThread().getName());

        ThreadEmptyImpl t2 = new ThreadEmptyImpl();
        t2.start(); // This checks for run() in "ThreadEmptyImpl" class, but it cant find this
        // So it invokes run() in Thread class which is empty implementation, so t2.start()
        // calling run() in Thread class does nothing
    }
}
