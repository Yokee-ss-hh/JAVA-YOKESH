package OOPS;

class City{
    String name;
    int number;

    int fff;
    float kkk;


    static int gg = 23;

    final int hh = 21;

    City(String name, int number, int fff, float kkk){
        this.name = name;
        this.number = number;
        this.fff = fff;
        this.kkk = kkk;
    }

    public void print(){
        System.out.println("Parent class");
    }

    public void parentPrint(){
        System.out.println("I am parentPrint method");
    }
    public String type(){
        return "City";
    }
}
class Village extends City{

    static int ll = 564;
    float f;
    double d;

    Village(String x, int y,float k, double g, int fff, float kkk){
        super(x,y,fff,kkk);
        this.f = k;
        this.d = g;
    }

    @Override
    public String type(){
        return "Village";
    }

    public void childPrint(){
        System.out.println(super.name);
        System.out.println(super.number);
        super.parentPrint();
        System.out.println("I am childPrint method");
    }
}
public class Inheritance {
    public static void main(String[] args) {
        City c = new City("Pakala",123,321,123.3212f);
        Village v = new Village("abc",34,9.654f,34.432,1000,1000.00f);

        System.out.println(c.name);
        System.out.println(c.number);
        System.out.println(c.type());
        c.print();
        c.parentPrint();

        // Instance data members of parent classes are available in child classes with no data in them.
        // They are available as a declared variables and java hides them.
        // If we declare data members in child class same as parent class, We need to explicitly initialize
        // them using constructor / object
        // If we don't declare data members in child class then variables of parent class can be used by
        // initializing data to them using super() method.
        // methods of parent class are accessible in child class directly
        // static and final variables of parent class are not masked and hided by java for child class
        System.out.println(v.name);
        System.out.println(v.number);
        System.out.println(v.f);
        System.out.println(v.d);
        System.out.println(v.type());
        v.print();
        v.childPrint();
        System.out.println(v.gg); // static data member of parent class, No masking by java
        System.out.println(v.hh); // final data member of parent class, No masking by java

        // static data in parent class is accessible in child class
        // Changing static variable of parent class using parent class name / child class name
        // will affect permanently in for both parent and child classes. Below is the demo
        System.out.println(City.gg);
        System.out.println(Village.gg);
        System.out.println(Village.ll);
        City.gg = 44;
        System.out.println(City.gg);
        System.out.println(Village.gg);
        System.out.println(Village.ll);

        System.out.println(c.fff);
        System.out.println(c.kkk);

        System.out.println(v.fff);
        System.out.println(v.kkk);
    }
}
