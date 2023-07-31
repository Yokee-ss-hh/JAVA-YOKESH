package MultiThreading;

class ThreadImplInt1 implements Runnable{
    @Override
    public void run() {
        System.out.println("I am called by 1 st child thread: "+Thread.currentThread().getName());
    }
}

public class ThreadCreation2 {
    public static void main(String[] args) {

        Runnable ThreadImplInt2 = () ->{
            System.out.println("I am called by 2nd child thread: "+Thread.currentThread().getName());
        };

        Runnable ThreadImplInt3 = new Runnable(){
         public void run(){
             System.out.println("I am called by 3rd child thread: "+Thread.currentThread().getName());
         }
        };

        ThreadImplInt1 t = new ThreadImplInt1();
        Thread t1 = new Thread(t);
        t1.start();

        Thread t2 = new Thread(ThreadImplInt2);
        t2.start();

        Thread t3 = new Thread(ThreadImplInt3);
        t3.start();
    }
}
