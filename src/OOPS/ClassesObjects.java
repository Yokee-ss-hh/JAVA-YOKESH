package OOPS;

public class ClassesObjects {
    int a;
    String b;
    boolean c;
    static int number;

    final int finalNumber1 = 100; // Cannot be modified once initialized

    // As soon as java encounters new keyword, It searches for any constructor available in the class
    // If no constructor is available, It provides itself a default constructor, else it raises error that
    // no proper constructor is available

    static final int finalNumber2 = 200; // Belongs to the class
    public ClassesObjects(int x, String y, boolean z){
        this.a = x;
        this.b = y;
        this.c = z;
    }


    public static void main(String[] args) { // Main method

        ClassesObjects.number = 1000;
        System.out.println(ClassesObjects.number);

        ClassesObjects op1 = new ClassesObjects(10,"yokesh",true);

        System.out.println(op1.a);
        System.out.println(op1.b);
        System.out.println(op1.c);
        // modifying static data of a class with op1
        op1.number = 1001;
        System.out.println(op1.number); // 1001
        // changing static data using object will affect real static data
        System.out.println(ClassesObjects.number); // 1001

        ClassesObjects op2 = new ClassesObjects(120,"Java",false);
        System.out.println(op2.a);
        System.out.println(op2.b);
        System.out.println(op2.c);
        // modifying static data of a class with op2
        op2.number = 1002;
        System.out.println(op2.number);
        // changing static data using object will affect real static data
        System.out.println(ClassesObjects.number); // 1002

        // Instance variables cannot be accessed using class name

        // static data can be accessed by objects and class
        System.out.println(op1.number);
        System.out.println(op2.number);
        System.out.println(ClassesObjects.number);

        // Imp Note: Instances of class can change static data any number of times
        // Initially static data number is 1000
        // op1 object changed static data number to 1001
        // op2 object changed static data number to 1002
        // Now, Even though we access static data number using class name also gives 1002

        // final data in a class can be accessed using only objects but not with class
        System.out.println(op1.finalNumber1);
        System.out.println(op2.finalNumber1);
        // System.out.println(oops1.finalNumber1); -> Throws error because finalNumber1 is non-static
        // field which is accessing from static main method.
        // But if we try to access static final data from main method, Compiler will not throw error
        // because static final data can be accessed from static main method which is valid.

        // static final data in a class can be accessed using both objects and class
        System.out.println(op1.finalNumber2);
        System.out.println(op2.finalNumber2);
        System.out.println(ClassesObjects.finalNumber2);

        // Finally,
        // Instance variables : Can only be accessed and modified by objects
        // static variables: Can be accessed and modified by objects and classes
        // final variables: Cannot be modified once initialized, Must be initialized at the time
        // of declaration. Can be accessed only by objects, but not with class name
        // static final variables: Can be accessed by objects and class name, But cannot be modified
        // Static data can only accessed in static methods only
    }
}
