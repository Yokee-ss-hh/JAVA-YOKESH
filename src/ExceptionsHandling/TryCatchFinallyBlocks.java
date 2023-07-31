package ExceptionsHandling;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class TryCatchFinallyBlocks {
    public static void main(String[] args) {
        // 1. try block executes everytime
        // 2. finally block executes even with (or) without exceptions
        // 3. catch only executes when exception is raised only
        try{
            System.out.println(12/0);
        }
        catch (Exception e){
            System.out.println(e.getClass());
            System.out.println("catch block is being executed");
        }
        finally {
            System.out.println("ArithmeticException is handled!!");
        }

        // catch block will be ignored if there is no exception raised in try block
        try{
            System.out.println(12/10);
        }
        catch (Exception e){
            System.out.println("In catch block");
        }
        finally {
            System.out.println("I will be executed all the time");
        }

        // multiple catch blocks are allowed
        try{
            int a[]=new int[5];
            System.out.println(a[10]);
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception occurs");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Parent Exception occurs");
        }
        finally {
            System.out.println("Executes everytime");
        }

        // If we don't know type of exception try block raises, We can use Exception keyword in catch block
        try{
            System.out.println(12/0);
        }
        catch (Exception e){
            System.out.println(e.getClass());
        }
    }
}
