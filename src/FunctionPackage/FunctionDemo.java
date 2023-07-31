package FunctionPackage;
import java.util.function.*;

public class FunctionDemo {
    public static void main(String[] args) {

        // function interface is an FunctionalInterface:
        // A interface is FunctionalInterface if it has only 1 abstract methods and
        // many more default and static methods.

        // function interface has 4 methods
        // Abstract method: apply()
        // 2 default methods: compose() and andThen()
        // static method: identity()

        // 1) Function takes 1 parameter
        Function<Integer,Integer> func = x -> x+2;
        System.out.println(func.apply(20));

        // BiFunction takes 2 parameters
        BiFunction<Integer,String,String> biFunc = (x,y) ->{
          return Integer.toString(x)+y;
        };
        System.out.println(biFunc.apply(10,"20"));

        // andThen takes 1 function output and pass as input to another function
        Function<Integer,Integer> func1 = x -> x*10;
        Function<Integer,Integer> func2 = y -> y/10;
        Function<Integer,Integer> func3 = func1.andThen(func2);
        System.out.println(func3.apply(2));

        // compose is reverse of andThen(), In below example compose
        // will be applied first to func2 and then to func1
        Function<Integer,Integer> func4 = func1.compose(func2);
        System.out.println(func4.apply(2));

        BiFunction<Integer,Integer,Integer> func5 = (x,y) ->{
            return x+y;
        };
        Function<Integer,Integer> func6 = (x) -> x+10;
        BiFunction<Integer,Integer,Integer> func7 = func5.andThen(func6);
        System.out.println(func7.apply(1,2));
        // compose is not there for BiFunctions

        // IntFunction takes only int value as input and returns output of type 'R'
        IntFunction<String> intFunction = (a) ->{
            return Integer.toString(a);
        };
        System.out.println(intFunction.apply(23));

        // DoubleFunction takes double input and returns output of type 'R'
        DoubleFunction<Long> doubleFunction = (a) ->{
          return Long.valueOf((long) a);
        };
        System.out.println(doubleFunction.apply(23.4321));

        // LongFunction takes long value as input and returns output of type 'R'
        LongFunction<Integer> longFunction = (x) ->{
          int i = (int)(x);
          return Integer.valueOf(i);
        };
        System.out.println(longFunction.apply(423442332L));
    }
}
