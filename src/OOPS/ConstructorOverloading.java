package OOPS;

import java.sql.SQLOutput;

public class ConstructorOverloading {
    int a;
    String b;

    // Constructor overloading by varying number of parameters and type of parameters

    ConstructorOverloading(){
        System.out.println("Default Constructor");
    }

    ConstructorOverloading(int x, String y){
        a = x;
        b = y;
        System.out.println("I am overloaded constructor with int and String");
    }

    ConstructorOverloading(String x, int y){
        a = y;
        b = x;
    }

    ConstructorOverloading(int x, String y, double z){
        // this() should be called as a first line in any overloaded constructor to call default constructor
        this(); // Calls default constructor
        System.out.println(Integer.toString(x)+y+Double.toString(z));
    }

    ConstructorOverloading(int x, String y, String z){

        this(x,y); // This calls ConstructorOverloading(int x, String y) and prints text inside it
    }

    public static void main(String[] args) {
        ConstructorOverloading co1 = new ConstructorOverloading(); // Calls default constructor

        ConstructorOverloading co2 = new ConstructorOverloading(21,"yokesh");
        System.out.println(co2.a);
        System.out.println(co2.b);

        ConstructorOverloading co3 = new ConstructorOverloading("kusuma",24);
        System.out.println(co3.a);
        System.out.println(co3.b);

        ConstructorOverloading co4 = new ConstructorOverloading(29,"BNN",43.234);

        ConstructorOverloading co5 = new ConstructorOverloading(44,"forty","four");
    }
}
