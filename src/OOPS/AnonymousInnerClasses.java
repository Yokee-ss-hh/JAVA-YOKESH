package OOPS;
// This file is the extension from NestedClasses -> InnerClasses -> type 3 of inner classes i.e,
// Anonymous classes:
// Anonymous classes are used to extend a class and to implement an interface

// Anonymous class cannot have a constructor because we don't know the class name
// what java uses in place of anonymous class

interface Bus {
    int u = 99;
    void busMethod(int a);
}

class Lorry{
    int x = 23;
    int age;
    String name;

    Lorry(int x , String name){
        age = x;
        this.name = name;
    }
    void lorryMethod(){
        System.out.println("I am in Lorry class");
    }
}
public class AnonymousInnerClasses {
    public static void main(String[] args) {

        int aaa = 234; // local variables can be accessed inside anonymous inner classes

        Bus b = new Bus(){
            int xoxo = 321;
          public void busMethod(int a){
                System.out.println(a);
              System.out.println(aaa);
              System.out.println(xoxo);
            }
        };
        b.busMethod(20);

        Lorry l = new Lorry(20,"my lorry"){
            @Override
          void lorryMethod(){
              System.out.println("I am in anonymous class");
                System.out.println(aaa);
          }
        };
        System.out.println(l.age);
        System.out.println(l.name);
        System.out.println(l.x);
        l.lorryMethod();
        }
}
