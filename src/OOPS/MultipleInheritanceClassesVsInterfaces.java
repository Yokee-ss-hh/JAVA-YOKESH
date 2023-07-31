package OOPS;

// A class cannot extend 2 or more classes
// If we try to do, It throws error as "class cannot extend multiple classes" because
// What if class1 and class2 have same methods and class3 extends both classes and compiler
// don't know which method it can call as the method is same in both super classes. This is called a
// diamond problem. That's why java don't support multiple inheritance

// A class can implement multiple interfaces
// A class cannot implement same methods with different return type which are defined in multiple interfaces
// A class can implement same methods with same return type which are defined in multiple interfaces

interface inter1{
    void m1();
}
interface inter2{
    String m1();
}

//class Cls1 implements inter1,inter2{
//    void m1(){
//        System.out.println("m1");
//    }
//
//    String m1(){
//        System.out.println("m1");
//    }
//}
// Un commenting above code throws error and java don't allow a class to implement 2 interfaces
// each having same method name but with different return types

// Question: Can a java class implements 2 interfaces each having same method name and same return type?
// YES !!! But compiler cannot guarantee which interface method it is implemented by the class

interface inter3{
    void m2();
}
interface  inter4{
    void m2();
}
class Cls2 implements inter3,inter4{
    public void m2(){ // We don't for which interface this method is implemented
        System.out.println("Implemented method");
    }
}

// Multiple inheritance using interfaces in java
interface swimable{
    void swim();
}
interface walkable{
    void walk();
}
class Duck implements swimable,walkable{
    public void swim(){
        System.out.println("I am swimming");
    }
    public void walk(){
        System.out.println("I am walking");
    }
}

public class MultipleInheritanceClassesVsInterfaces {
    public static void main(String[] args) {
        Cls2 cls = new Cls2();
        cls.m2();

        // multiple inheritance using interfaces
        Duck duck = new Duck();
        duck.swim();
        duck.walk();
    }
}


