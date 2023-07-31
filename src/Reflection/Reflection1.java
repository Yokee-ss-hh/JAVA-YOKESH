package Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

class Dog{
    void getData(){
        System.out.println("Class Dog");
    }
}

public class Reflection1 {
    // There is a class in Java named "Class" that keeps all the information about objects
    // and classes at runtime.
    // The object of "Class" can be used to perform reflection.
    public static void main(String[] args){
        try{
            Class cls = Class.forName("Dog");
            Method[] methods = cls.getMethods();
            System.out.println(Arrays.toString(methods));
        }
        catch (ClassNotFoundException cnfe){
            System.out.println(cnfe.toString());
        }
    }
}
