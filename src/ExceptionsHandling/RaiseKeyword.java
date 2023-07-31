package ExceptionsHandling;

public class RaiseKeyword {

    static void raiseSomeException() throws Exception{
        throw new Exception("Yokesh Exception");
    }

    public static void main(String[] args) {
        try{
            raiseSomeException();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
