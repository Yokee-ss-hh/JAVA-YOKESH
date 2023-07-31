package FunctionPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class ConsumersDemo {
    public static void main(String[] args) {
        // Consumer<T> has 2 methods
        // 1) abstract method which returns nothing: void accept(T t)
        // 2) default method andThen()
        Consumer<List<Integer>> consume = x -> System.out.println(x);
        consume.accept(Arrays.asList(1,2,3,4,5));

        int[] myArray = new int[]{1,2,3,4,5};
        Consumer<int[]> consume1 = x -> {
            for(int i=0; i<x.length;i++){
                x[i] = x[i]*x[i];
            }
        };
        Consumer<int[]> consume2 = x -> {
            System.out.println(Arrays.toString(x));
        };
        Consumer<int[]> consume3 = consume1.andThen(consume2);
        consume3.accept(myArray);

        // Another example using method referencing
        List<Integer> list = new ArrayList<>(List.of(10,20,30,40,50));
        Consumer<List<Integer>> listConsumer = System.out::println;
        // The above line is equal to
        Consumer<List<Integer>> lis1Consumer1 = x -> System.out.println(x);
        listConsumer.accept(list);
        lis1Consumer1.accept(list);

        // BiConsumer
        BiConsumer<Integer,Integer> biConsumer = (a,b) ->{
            System.out.println(a+b);
        };
        biConsumer.accept(10,20);

        BiConsumer<Integer,Integer> biConsumer1 = (a,b) ->{
            System.out.println(String.format("The sum of a and b is: %d",a+b));
        };
        BiConsumer<Integer,Integer> biConsumer2 = (a,b) ->{
            System.out.println(String.format("The multiplication of a and b is: %d",a*b));
        };
        BiConsumer<Integer,Integer> biConsumer3 = biConsumer1.andThen(biConsumer2);
        biConsumer3.accept(10,20);

        // IntConsumer
        IntConsumer intConsumer = (x) ->{
            System.out.println(x);
        };
        intConsumer.accept(20);

        // LongConsumer
        LongConsumer longConsumer = (x) ->{
            System.out.println(x);
        };
        longConsumer.accept(23421312);

        // DoubleConsumer
        DoubleConsumer doubleConsumer = (x) ->{
            System.out.println(x);
        };
        doubleConsumer.accept(23.42312);

    }
}
