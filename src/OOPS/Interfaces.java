package OOPS;

// 1) All variables are implicitly static and final
// 2) All methods like abstract, static, instance methods and default methods are public
// 3) Interfaces can have static and default methods and body of these methods are mandatory
// It is not mandatory to implement default methods in implementing class
// If class implements default methods and an object of class calls it, Then call goes to implemented default
// method, else if class did not implement default method of interface then call goes to interface default method
// 4) Cannot create static and default methods, and it throws error
// 5) Interfaces can have private methods and static private methods
// 6) private and private static methods should be used within interface only
// and these should be used inside other static and non-static methods only
// 7) private and private static methods cannot be abstract
// 8) private non-static methods cannot be used inside private static methods
// 9) You cannot override the static method of the interface
// you can just access them using the name of the interface.
// If you try to override a static method of an interface by defining a similar
// method in the implementing interface,
// it will be considered as another (static) method of the class
// 10) An interface can extend another interfaces
// 11) A class can implement multiple interfaces at the same time
// NOTE: While implementing un-implemented abstract methods and default methods of interfaces in class
// make sure to use "public" keyword before methods
// Interfaces cannot have constructors and cannot create objects of interfaces

// BIG NOTE:
// Static methods are inherited from super class to subclass in normal inheritance
// So, subclass object can access static method of super class
// But, In interfaces the case is different
// Static methods of interfaces are not inherited to subclasses, so object of subclass cannot call interface
// static method directly, so use Interface name to call interface static method
// But, variables in interfaces can be accessed using subclass object even though they are static and final by default
interface InterfaceOne{
    int x = 23;
    void method1();

    static void method2(){
        System.out.println("I am static method in interface");
    }
    default void method3(){
        System.out.println("I am default method in interface");
    }
    default void defaultMethod(){
        System.out.println("I will be implemented again in next class");
    }
    private void method4(){
        System.out.println("I am private method");
    }
    private static void method5(){
        System.out.println("I am static private method");
    }

    // Can use default method to call private and static private methods in them
    default void getPrivateMethods1(){
        method4();
        method5();
    }

    // Use static method to call static private method in them, Cannot access private method inside
    // static method directly. It will throw error.
    static void getPrivateMethods2(){
        method5();
        // method4();  Un commenting it throw error
    }

}
class InterfaceClass implements InterfaceOne{

    static void method2(){
        System.out.println("I am static method in implementing class");
    }
    @Override
    public void method1(){
        System.out.println("I am implemented method");
    }
    // NOTE:
    // default method "method3()" is not overrided here in this class. Even though we didn't implemented
    // java won't throw error as there is a keyword default used with method body is implemented
    // So, We can implement default class again in this class as
    public void defaultMethod(){
        System.out.println("I re-implemented default method here");
    }
}

interface InterfaceTwo{
    void methodM1();
}
interface InterfaceThree{
    void methodM2();
}

// interface extending 2 interfaces
interface InterfaceFour extends InterfaceTwo, InterfaceThree{
    void methodM3();
}

// class implementing 2 interfaces
class ClassYokesh implements InterfaceTwo, InterfaceThree{
    public void methodM1(){
        System.out.println("Implementing method of InterfaceTwo in class ClassYokesh");
    }
    public void methodM2(){
        System.out.println("Implementing method of InterfaceThree in class ClassYokesh");
    }
}

// class implementing an interface which extended 2 interfaces
class ClassYok implements InterfaceFour{
    public void methodM1(){
        System.out.println("Implementing method of InterfaceTwo in class ClassYok");
    }
    public void methodM2(){
        System.out.println("Implementing method of InterfaceThree in class ClassYok");
    }
    public void methodM3(){
        System.out.println("Implementing method of InterfaceFour in class ClassYok");
    }
}

public class Interfaces{
    public static void main(String[] args) {
        InterfaceClass ic = new InterfaceClass();
        InterfaceOne ic2 = new InterfaceClass();
        System.out.println(ic.x); // Can call final static variable of interface using implemented class object
        System.out.println(InterfaceOne.x); // Can call final static variable of interface using interface name
        ic.method1();
        InterfaceOne.method2(); // calling using interface name
        ic.defaultMethod(); // As there is an implementation in class, java calls implemented method from class
        ic.method3(); // Calls default method from interface
        // NOTE: private and private static cannot be accessed using object outside the interface
        // So, We need to use some static/ default methods to call private/static private methods in them as
        ic2.defaultMethod(); // calls implemented method in class
        ic2.method3(); // class default method from interface as there is no implementation in the class
        ic.method2(); // Calling static method of class which has same name as static method of interface using object
        InterfaceClass.method2(); // Calling static method of class which has same name as static method of interface using class

        // Let's call private and private static methods of interfaces using default and static methods of interfaces
        ic.getPrivateMethods1(); // It is a default method in interface which don't have implementation in class
        // so the call goes to interfaces
        InterfaceOne.getPrivateMethods2();// Called using interface name as this method is static method of interface

        ClassYokesh cy = new ClassYokesh();
        cy.methodM1();
        cy.methodM2();

        ClassYok cy1 = new ClassYok();
        cy1.methodM1();
        cy1.methodM2();
        cy1.methodM3();


        // Final Notes:
        // ClassImpl cls = new ClassImpl();
        // Implementing class object of interface can access default method of interface of the class if class don't have implementation of the default method
        // If class have default method implementation, then call goes to class rather than going to interface
        // Class object cannot access interface static method directly, we need to call using interface name

        // InterfaceInt i = new ClassImpl();
        // Now, 'i' can call default method only, Cannot call static method of interface using interface reference
        // But the class can call static method of class using class object (Important point)
        // If 'i' reference calls abstract method , then call goes to implemented method in ClassImpl due to
        // method overriding.
    }
}