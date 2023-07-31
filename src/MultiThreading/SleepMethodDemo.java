package MultiThreading;

public class SleepMethodDemo {
    public static void main(String[] args) {
        System.out.println("I will be printed immediately");
        try{
            Thread.sleep(10000);
        }
        catch (InterruptedException e){
            System.out.println(e.toString());
        }
        System.out.println("I will be executed after 10 seconds");
    }
}
