package FunctionPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class PredicatesDemo {
    public static void main(String[] args) {
        // There are 1 abstract method, 2 static and 2 default methods
        // abstract: test()
        // static: isEqual() and not()
        // default: and(), or() and negate()

        // abstract method
        System.out.println("--------------Default methods---------------");

        Predicate<Integer> p1 = x -> x%2==0;
        System.out.println(p1.test(10));
        System.out.println(p1.test(11));

        // default methods
        System.out.println("-----------default methods---------------");
        Predicate<Integer> p2 = x -> x%2 == 0;
        Predicate<Integer> p3 = y -> (y+2)%2 == 0;
        Predicate<Integer> p4 = p2.and(p3);
        System.out.println(p4.test(10));
        System.out.println(p4.test(11));

        Predicate<Integer> p5 = x -> x%2 == 0;
        Predicate<Integer> p6 = y -> (y+2)%2 == 0;
        Predicate<Integer> p7 = p5.or(p6);
        System.out.println(p7.test(10));
        System.out.println(p7.test(11));

        Predicate<String> p8 = x -> x.length() > 5;
        Predicate<String> p9 = p8.negate();
        System.out.println(p9.test("yokesh"));

        // Static methods
        System.out.println("---------Static methods----------");
        // isEqual() uses Object.equals(Object,Object) internally
        String s = "yokesh";
        Predicate<String> p10 = Predicate.isEqual(s);
        System.out.println(p10.test("yokesh"));
        System.out.println(p10.test(s));

        // Inorder to negate an existing predicate not() is used
        Predicate<List<Integer>> p11 = x -> {
          if(x.size() > 5){
              return true;
          }
          return false;
        };
        Predicate<List<Integer>> p12 = p11.negate();
        System.out.println(p12.test(new ArrayList<>(List.of(1,2,3,4,5))));
        System.out.println(p12.test(new ArrayList<>(List.of(1,2,3))));
        System.out.println(p12.test(new ArrayList<>(List.of(1,2,3,4,5,6,7))));

        // BiPredicate
        BiPredicate<Integer,Integer> biPredicate = (x,y) ->{
          return x==y;
        };
        System.out.println(biPredicate.test(2,2));
        // Similarly we can use negate(), and(), or() with BiPredicates

        // IntPredicate takes int value as input and returns boolean
        IntPredicate intPredicate = (x) -> {
           if(x % 2 == 0){
               return true;
           }
           else{
               return false;
           }
        };
        System.out.println(intPredicate.test(2));

        // LongPredicate takes long value as input and returns boolean
        LongPredicate longPredicate = (x) ->{
          return true;
        };
        System.out.println(longPredicate.test(23));

        // DoublePredicate takes double value as input and returns boolean
        DoublePredicate doublePredicate = (x) ->{
          return false;
        };
        System.out.println(doublePredicate.test(21321312.212));
    }
}
