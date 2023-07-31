package OOPS;

class A{
    void run(){
        System.out.println("I am from Class A");
    }
}
class B extends A{

    @Override
    void run(){
        System.out.println("I am from class B");
    }
}

class Bike{
    void run(){
        System.out.println("I am from Bike class");
    }
}
class Ktm extends Bike{
    @Override
    void run(){
        System.out.println("I am from Ktm class");
    }
}
class KtmDuke extends Ktm{
    @Override
    void run(){
        System.out.println("I am from Ktm Duke class");
    }
}
class KtmDukeNew extends KtmDuke{

}

// What if subclass is not overriding method in parent class, and we use
// Parent class reference using child class object
class Animal{
    void walkAnimal(){
        System.out.println("I am from Animal class");
    }
}
class Dog extends Animal{
    void walkDog(){
        System.out.println("I am from Dog class");
    }
}

// Polymorphism with data member
class Universe{
    String color = "black";
}
class Earth extends Universe{
    String color = "white";
}

public class Polymorphism {
    // Compile time polymorphism -> Method overloading
    // Run time polymorphism -> Method overriding / Dynamic method dispatch
    public static void main(String[] args) {
        A a = new A();
        a.run();
        B b = new B();
        b.run();
        A c = new B(); // Upcasting -> Reference variable of parent class with child class object
        c.run(); // Prints child class override method in class B
        // An overridden method is called through the reference variable of a superclass.
        // The determination of the method to be called is based on the object being referred to by
        // the reference variable.

        Bike bike1 = new Bike();
        Ktm bike2 = new Ktm();
        KtmDuke bike3 = new KtmDuke();
        KtmDukeNew bike4 = new KtmDukeNew();
        Bike bike5 = new Ktm();
        Bike bike6 = new KtmDuke();
        Bike bike7 = new KtmDukeNew();

        bike1.run();
        bike2.run();
        bike3.run();
        bike4.run();
        bike5.run();// Calls run() in class Ktm class
        bike6.run();// Calls run() in class KtmDuke class
        bike7.run();// Checks run() method in KtmDukeNew class. But, run() method is not overrided in
        // KtmDukeNew class, So it goes to its parent class i.e, KtmDuke class and checks whether
        // run() method is overrided there or not. As there is a run() method overrided it prints
        // "I am from KtmDuke class"

        Animal y1 = new Animal();
        Dog y2 = new Dog();
        Animal y3 = new Dog();
        // Note: Even though Dog class inherits from Animal class but Dog class has no overridden method
        // which is in Animal class, Using Parent class reference using Subclass object. It will go to
        // parent's class method
        y1.walkAnimal();
        y2.walkDog();
        y3.walkAnimal(); // Dog() class didn't overrided walkAnimal()
        // Even Animal y3 = new Dog() is created and y3.walkAnimal() is called, As walkAnimal() is not
        // there in Dog() class, It calls walkAnimal() from it's inherited parent class
        // So, It prints "I am from Animal class".

        // -----------------------------------------------
        // Static(Early) and dynamic(Late) binding
        // static binding: When type of object is determined at compile time
        // dynamic binding: When type of object is determined at run time
        // Static Binding: Animal a = new Animal();
        // Dynamic Binding: Animal b = new Dog();

        // Polymorphism for data members
        Universe u1 = new Universe();
        Earth e = new Earth();
        Universe u2 = new Earth();
        System.out.println(u1.color);
        System.out.println(e.color);
        System.out.println(u2.color); // Expects 'white' but it prints 'black' as data members cannot go under
        // polymorphism
        }
}
