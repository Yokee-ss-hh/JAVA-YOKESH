package MultiThreading;

public class JoinMethodDemo{
    public static void main(String[] args){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        try{
            t1.join();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        t2.start();
        try{
            t2.join();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        System.out.println("I am executed by main thread");
    }
    // "main" thread waits until "Thread-1" execution completes
    // "Thread-1" waits until "Thread-0" execution completes
    // "Thread-0" execution happens first
}
