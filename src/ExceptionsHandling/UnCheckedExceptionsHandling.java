package ExceptionsHandling;

public class UnCheckedExceptionsHandling {
    // UnCheckedExceptions will not be checked by compiler at compile time
    // At run time exceptions will be thrown
    // So, It's better to use try, catch blocks
    public static void main(String[] args) {
        // ArithmeticException
        try{
            System.out.println(10/0);
        }
        catch (ArithmeticException e){
            System.out.println(e.getClass());
        }

        // NullPointerException
        String s = null;
        try{
            System.out.println(s);
        }
        catch (NullPointerException np){
            System.out.println(np.getClass());
        }

        // NumberFormatException
        try{
            Integer s1 = Integer.parseInt("null");
            // Similarly, The below also comes under NumberFormatException
            // Float s2 = Float.parseFloat("");
            // Integer s3 = new Integer(" 123 ");
        }
        catch (NumberFormatException nf){
            System.out.println(nf.getClass());
        }
    }
}
