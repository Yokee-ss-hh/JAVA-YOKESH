package OOPS;

// If a subclass defines a static method with the same signature as a static method in the superclass
// then the method in the subclass hides the one in the superclass. This mechanism happens because the
// static method is resolved at the compile time. Static method bind during the compile time using the
// type of reference not a type of object.
// In method hiding, method resolution is done on basis of reference class type
// In method overriding, method resolution is done on basis of object type
// This is different from method overriding, Look at the below example for the difference:

class Complex{
    public static void m1(){
        System.out.println("m1 method of complex class");
    }
    public void m2(){
        System.out.println("m2 method of complex class");
    }
}
class Sample extends Complex{
    public static void m1(){
        System.out.println("m1 method of sample class");
    }
    public void m2(){
        System.out.println("m2 method of sample class");
    }
}
public class MethodHiding {
    public static void main(String[] args) {
        Complex c1 = new Complex();
        Complex c2 = new Sample();
        c1.m1();
        c1.m2();
        c2.m1();
        c2.m2();
    }
}
