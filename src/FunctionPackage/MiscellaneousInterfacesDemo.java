package FunctionPackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.*;
import java.util.List;

public class MiscellaneousInterfacesDemo {
    public static void main(String[] args) {
        // BinaryOperator extends BiFunction interface
        // BinaryOperator interface has 2 methods: minBy and maxBy and both are static methods
        // BinaryOperator interface also can access methods of BiFunction interface
        // BiFunction provides apply() and andThen() methods in which apply() is abstract
        // and andThen() is default.
        // BinaryOperator<T> where, T is the type of output

        BinaryOperator<Integer> binaryOperator = (a,b) ->{
          return a+b;
        };
        System.out.println(binaryOperator.apply(10,20));

        Comparator<Integer> comparator = (x,y) -> x.compareTo(y);
        BinaryOperator<Integer> binaryOperator1 = BinaryOperator.minBy(comparator);
        System.out.println(binaryOperator1.apply(10,20));

        Comparator<Integer> comparator1 = (x,y) -> x.compareTo(y);
        BinaryOperator<Integer> binaryOperator2 = BinaryOperator.maxBy(comparator1);
        System.out.println(binaryOperator2.apply(10,20));

        IntBinaryOperator binaryOperator3 = (x,y) -> x*y;
        System.out.println(binaryOperator3.applyAsInt(10,20));

        LongBinaryOperator binaryOperator4 = (x,y) -> x+y;
        System.out.println(binaryOperator4.applyAsLong(10231312L,123123L));

        DoubleBinaryOperator binaryOperator5 = (x,y) -> x+y;
        System.out.println(binaryOperator5.applyAsDouble(31231.31231,312321.31231));

        // UnaryOperator extends Function interface
        UnaryOperator<Integer> unaryOperator = (x) -> x+10;
        System.out.println(unaryOperator.apply(10));

        IntUnaryOperator intUnaryOperator =(x) -> 90+x;
        System.out.println(intUnaryOperator.applyAsInt(90));

        LongUnaryOperator longUnaryOperator = (l) -> l+l;
        System.out.println(longUnaryOperator.applyAsLong(100));

        DoubleUnaryOperator doubleUnaryOperator = (d) -> d*2;
        System.out.println(doubleUnaryOperator.applyAsDouble(32.321));

        // IntToLongFunction, IntToDoubleFunction
        // LongToIntFunction, LongToDoubleFunction
        // DoubleToIntFunction, DoubleToLongFunction
        IntToLongFunction intToLongFunction = (x) -> x;
        System.out.println(intToLongFunction.applyAsLong(20));
        IntToDoubleFunction intToDoubleFunction = (x) -> x;
        System.out.println(intToDoubleFunction.applyAsDouble(20));

        LongToIntFunction longToIntFunction = (x) -> (int)x;
        System.out.println(longToIntFunction.applyAsInt(40));
        LongToDoubleFunction longToDoubleFunction = (x) -> (double)x;
        System.out.println(longToDoubleFunction.applyAsDouble(40));

        DoubleToIntFunction doubleToIntFunction = (x) -> (int)x;
        System.out.println(doubleToIntFunction.applyAsInt(32.2131));
        DoubleToLongFunction doubleToLongFunction = (x) -> (long)x;
        System.out.println(doubleToLongFunction.applyAsLong(32.2131));

        // ToIntFunction, ToLongFunction, ToDoubleFunction
        // ToIntBiFunction, ToLongBiFunction, ToDoubleBiFunction
        ToIntFunction<Double> toIntFunction = (x) -> (int)(x+10);
        System.out.println(toIntFunction.applyAsInt(2.32));

        ToIntBiFunction<Long,Integer> toIntBiFunction = (x,y) -> (int)(x+y);
        System.out.println(toIntBiFunction.applyAsInt(2343413L,12312));

        ToLongFunction<Integer> toLongFunction = (x) -> x;
        System.out.println(toLongFunction.applyAsLong(213123));

        ToLongBiFunction<Integer,Float> toLongBiFunction = (x,y) -> (long) (x+y);
        System.out.println(toLongBiFunction.applyAsLong(2341,21.21f));

        ToDoubleFunction<Long> toDoubleFunction = (x) -> x;
        System.out.println(toDoubleFunction.applyAsDouble(123456L));

        ToDoubleBiFunction<Long,Double> toDoubleBiFunction =(x,y) -> x+y;
        System.out.println(toDoubleBiFunction.applyAsDouble(12345L,2.321));

        // ObjIntConsumer, ObjLongConsumer, ObjDoubleConsumer
        ObjIntConsumer<Integer[]> objIntConsumer= (x,y) -> System.out.println(x.length*y);
        objIntConsumer.accept(new Integer[]{1,2,3,4,5}, 10);

        ObjLongConsumer<List> objLongConsumer =(x,y) -> {
          x.add(y);
          System.out.println(x);
        };
        objLongConsumer.accept(new ArrayList<>(List.of(1,2,3,4,5)),6);

        ObjDoubleConsumer<Float> objDoubleConsumer = (x,y) ->{
            System.out.println(x+y);
        };
        objDoubleConsumer.accept(12.321f,12.12);
    }
}