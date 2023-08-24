package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class c = Class.forName("Reflection.Dog");

        System.out.println("------------getDeclaredMethods------------------");
        Method[] methods = c.getDeclaredMethods();
        System.out.println(Arrays.toString(methods));

        for(Method m: methods){
            System.out.println("method name:"+" "+m.getName());
        }

        System.out.println("-------------parameters of methods--------------");
        for(Method m: methods){
            Parameter[] parameters = m.getParameters();
            System.out.println("Method:"+" "+m.getName()+" parameter count: "+m.getParameterCount());
            System.out.println("Method:"+m.getName()+" return type"+m.getReturnType());
            for(Parameter p: parameters){
                System.out.println(m.getName()+" :"+p.getName());
            }
        }

        System.out.println("--------------constructors-----------------");
        Constructor[] constructors = c.getDeclaredConstructors();
        for(Constructor con: constructors){
            System.out.println(con.getName());
            Parameter[] p = con.getParameters();
            for(Parameter para:p){
                System.out.println("Constructor "+con.getName()+" :"+para.getName());
            }
        }

        System.out.println("-----------fields-------------");
        Field[] fields = c.getFields();
        for(Field f:fields){
            System.out.println(f.getName());
        }

        System.out.println("---------------Data setting---------------------");
        Dog d = new Dog();
        Field f1 = c.getField(fields[0].getName());
        f1.setAccessible(true);
        f1.set(d,"murray");
        Field f2 = c.getField(fields[1].getName());
        f2.setAccessible(true);
        f2.set(d,"goss");
        System.out.println(f1.get(d));

    }
}
