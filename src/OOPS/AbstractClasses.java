package OOPS;

import org.w3c.dom.ls.LSOutput;

// declared using 'abstract' keyword
// Can contain both abstract and non-abstract methods
// Can contain static, instance , final, static final variables
// Cannot create static abstract methods:
// Because "abstract" means: "Implements no functionality", and "static" means: "There is functionality
// even if you don't have an object instance". And that's a logical contradiction.
// Cannot create final abstract methods:
// Because If we make abstract method as final we cannot inherit it in the subclass to override them.
// Similarly, We cannot have abstract static final methods also...
// If at least 1 method in a class is abstract then class should be declared as abstract
// If an extended subclass cannot provide implementation to the abstract methods then it should be declared as
// abstract, and it's subclass should provide implementation to the abstract method.
// We cannot create object fof abstract class
// Can have constructors

abstract class Abstract1{
    static int x = 213;
    static final int y = 45678;
    final String z = "abstract";
    float k = 43.2345f;

    int value;
    abstract void method1();

    Abstract1(){
        System.out.println("Default constructor");
    }
    Abstract1(int value){
        this.value = value;
    }

    int valueMethod(){
        return this.value;
    }
    void method2(){
        System.out.println("instance method");
    }
    static void method3(){
        System.out.println("Static method");
    }
    final void method4(){
        System.out.println("Final method");
    }
    static final void method5(){
        System.out.println("Static final method");
    }
}

class Implementation extends Abstract1{

    Implementation(){
        super(10);
    }
    Implementation(int impValue){
        this.value = impValue;
    }
    @Override
    void method1(){
        System.out.println(" I am the implementation of abstract method");
    }

}
public class AbstractClasses {
    public static void main(String[] args) {
        Implementation i = new Implementation(12);
        Abstract1 i1 = new Implementation();
        System.out.println(i.value); // Gets value from Implementation class
        System.out.println(i.valueMethod()); // Calls method in Abstract class with Implementation class object which
        // returns i.value = 12
        System.out.println(i1.value); // Calls Abstract class variable value
        System.out.println(i1.valueMethod());// Calls Abstract class method with Abstract class variable reference
        // which return i1.value = 10
        i.method1();
        i.method2();
        i.method3();
        i.method4();
        i.method5();
        System.out.println(i.x);
        System.out.println(i.y);
        System.out.println(i.z);
        System.out.println(i.k);
    }
}
