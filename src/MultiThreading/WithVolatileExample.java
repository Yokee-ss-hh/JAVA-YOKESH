package MultiThreading;

class SharedVarCount{
    public volatile boolean running = true;
}

public class WithVolatileExample {
    public static void main(String[] args) throws InterruptedException {
        SharedVarCount sharedVariableCount = new SharedVarCount();
        Runnable runnable = ()->{
            int count =0;
            while (sharedVariableCount.running){
                count++;
            }
            System.out.println("Count :"+count);
        };
        Thread thread = new Thread(runnable,"thread-1");
        thread.start();
        Thread.sleep(3000);
        sharedVariableCount.running=false;
        // Now the worker thread stops and prints the count value as we used volatile
    }
}
