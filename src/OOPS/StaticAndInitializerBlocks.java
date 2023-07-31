package OOPS;

public class StaticAndInitializerBlocks {

    // Static blocks are used to initialize static content
    // Executed first when class is executed
    // Executes only once per class
    // Cannot access Non-static data inside static block
    // Can place anywhere in the class
    // static block will execute even when there is no main method and no objects are created

    // Initializer class is used to initialize instance variables
    // Executes every time a new objects are created
    // Can place anywhere in the class

    int a;
    int b = 10;

    static int c = 11;

    static int d;

    StaticAndInitializerBlocks(){
        System.out.println("Default constructor");
    }

    StaticAndInitializerBlocks(int a){
        this.a = a;
    }

    static{
        d = 999;
        System.out.println("Inside static block");
    }

    {
        a = 333;
        System.out.println("Inside initializer block");
    }

    public static void main(String[] args) {
        StaticAndInitializerBlocks s1 = new StaticAndInitializerBlocks();
        System.out.println(s1.a); // gets value from initializer block
        System.out.println(s1.b);

        StaticAndInitializerBlocks s2 = new StaticAndInitializerBlocks(21);
        System.out.println(s2.a); // Gets data from constructor which overrides the value of
        // 'a' which was set as '333' in initializer block to '21'.
        System.out.println(s2.b);

        System.out.println(StaticAndInitializerBlocks.c);
        System.out.println(StaticAndInitializerBlocks.d); // 999

        StaticAndInitializerBlocks.d = 22222; // This line overwrites the value of 'd' which was
        // initialized in static block from '999' to '2222'
        System.out.println(StaticAndInitializerBlocks.c);
        System.out.println(StaticAndInitializerBlocks.d); // 2222
    }

}
