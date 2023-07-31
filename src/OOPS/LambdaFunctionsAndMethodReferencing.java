package OOPS;

// Lambda functions are used to implement an abstract method of FunctionalInterface only
// FunctionalInterface is the interface having only 1 abstract method

import java.util.Arrays;
import java.util.function.Function;

@FunctionalInterface
interface MyInterface{
    Integer returnInt(int x);

}

@FunctionalInterface
interface YourInterface{
    String returnNothing();
}

@FunctionalInterface
interface MyInterface1 {
    Polar display(String output);
}
class Polar {
    public Polar(String output) {
        System.out.print(output);
    }
}

// Instead of using lambdas we can also use method referencing operator also
class Yokesh{

    Yokesh(){
        System.out.println("Default Constructor");
    }
    static String yokeshTwo(){
        return "Static method in Yokesh class";
    }

    static Integer yokeshOne(int i) {
        return i+i;
    }

    int yokeshThree(int x){
        return x+90;
    }
}

public class LambdaFunctionsAndMethodReferencing {
    public static void main(String[] args) {
        MyInterface mi = (x) -> {
            return Integer.valueOf(x);
        };
        System.out.println(mi.returnInt(10));
        System.out.println(mi.returnInt(10).getClass());

        // 1) Referencing static method of class to interface
        // Lambda expression looks like: (args) -> Class.staticMethod(args)
        MyInterface mi1 = Yokesh::yokeshOne;
        System.out.println(mi1.returnInt(10));

        YourInterface mi2 = Yokesh::yokeshTwo;
        System.out.println(mi2.returnNothing());

        // 2) Referencing instance method of a class to FunctionalInterface
        // Lambda expression looks like: (object, args) -> object.instanceMethod(args)
        Yokesh yokesh = new Yokesh();
        Function<Integer,Integer> mi3 = yokesh::yokeshThree;
        System.out.println(mi3.apply(10));

        // 3) Method reference to an instance method of an arbitrary object of a specific type
        // This type of method reference refers to nonstatic instance methods without creating a custom object.
        // It uses an anonymous object to refer to the instance method
        // Lambda expression looks like: (object, args) -> object.instanceMethod(args)
        String[] stringArray = { "Nisha", "Suman", "Amish", "Amisha", "Durgesh", "Esha", "Sarfaraz"};
        /* Method reference to an instance method of an arbitrary
         * object of a particular type
         */
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        for(String str : stringArray){
            System.out.println(str);
        }

        // 4) Referencing Constructor
        // Lambda expression looks like: (args) -> new ClassName(args)
        MyInterface1 ref = Polar::new;
        ref.display("Polar World!");
    }
}
