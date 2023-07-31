package ExceptionsHandling;

import java.util.HashMap;
import java.util.Map;

class InvalidAgeException extends Exception{
    InvalidAgeException(String message){
        super(message);
    }
}

class InvalidNameException extends Exception{

}
public class CustomExceptions {
    static void isValidAge(int age) throws InvalidAgeException{
        if(age < 18){
            throw new InvalidAgeException("Age must be greater than or equals to 18");
        }
    }
    public static void main(String[] args) {
        try{
            isValidAge(16);
        }
        catch (Exception e){
            System.out.println(e.getClass());
        }

        try{
            throw new InvalidNameException();
        }
        catch (Exception e) {
            System.out.println(e.getClass());
        }
    }
}
