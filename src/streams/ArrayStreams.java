package streams;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.*;
import java.util.stream.Collectors.*;

// Streams for primitive arrays are possible using static methods of Arrays class
// IntStream for int[]
// LongStream for long[]
// DoubleStream for double[]

// Streams from Collections:
// We can create stream objects from List, Set interface implementation classes
// But, We cannot create stream objects from Map interface implementation classes
// However, We can use keySet(), entrySet() and values() methods which has return types as
// Map.Entry, Set and Collection types.
public class ArrayStreams {

    public static void main(String[] args){
        System.out.println("****************IntStream********************");
        int[] a1 = {1,2,3,4,5,6};
        IntStream intStream1 = Arrays.stream(a1); // returns IntStream object

        // count() returns long
        long eleCount = intStream1.count();
        System.out.println(eleCount);
        IntStream intStream2 = Arrays.stream(a1);

        // sum()
        int eleSum = intStream2.sum();
        System.out.println(eleSum);

        // min() and max() returns OptionalInt
        IntStream intStream3 = Arrays.stream(a1);
        IntStream intStream4 = Arrays.stream(a1);
        OptionalInt eleMin = intStream3.min();
        OptionalInt eleMax = intStream4.max();
        System.out.println(eleMin);
        if(eleMin.isPresent()){
            System.out.println(eleMin.getAsInt());
        }
        System.out.println(eleMax);
        if(eleMax.isPresent()){
            System.out.println(eleMax.getAsInt());
        }

        // average() returns OptionalDouble
        IntStream intStream5 = Arrays.stream(a1);
        OptionalDouble eleAvg = intStream5.average();
        System.out.println(eleAvg);
        if(eleAvg.isPresent()){
            System.out.println(eleAvg.getAsDouble());
        }

        // findFirst(): returns first element in the stream, returns OptionalInt
        // findAny(): returns random element in the stream, returns OptionalInt
        IntStream intStream6 = Arrays.stream(a1);
        OptionalInt eleFindFirst = intStream6.findFirst();
        IntStream intStream7 = Arrays.stream(a1);
        OptionalInt eleFindAny = intStream7.findAny();
        System.out.println(eleFindFirst);
        if(eleFindFirst.isPresent()){
            System.out.println(eleFindFirst.getAsInt());
        }
        System.out.println(eleFindAny);
        if(eleFindAny.isPresent()){
            System.out.println(eleFindAny.getAsInt());
        }

        // allMatch() and anyMatch()
        // Returns true if any element in stream matches the predicate logic
        IntStream intStream8 = Arrays.stream(a1);
        boolean boolAnyMatch = intStream8.anyMatch((a)->{
            if(a % 2 == 0){
                return true;
            }
            return false;
        });
        System.out.println(boolAnyMatch);
        IntStream intStream9 = Arrays.stream(new int[]{2,4,6,8});
        boolean boolAllMatch = intStream9.allMatch((a)->{
           if(a % 2 == 0){
               return true;
           }
           return false;
        });
        System.out.println(boolAllMatch);

        // limit()
        // Takes a parameter and crops stream till that limit
        // Returns limited stream
        IntStream intStream10 = Arrays.stream(a1);
        IntStream intStream11 = intStream10.limit(3);
        System.out.println(Arrays.toString(intStream11.toArray()));
        // a1 stream is reduced from [1,2,3,4,5,6] to [1,2,3]

        // distinct()
        // returns IntStream which contains all distinct elements only
        IntStream intStream12 = Arrays.stream(new int[]{1,1,2,2,3,3,4,4,5,5});
        IntStream intStream13 = intStream12.distinct();
        System.out.println(Arrays.toString(intStream13.toArray()));

        // dropWhile()
        IntStream intStream14 = Arrays.stream(new int[]{1,2,3,4,5,6,7,8,9,10});
        IntStream intStream15 = intStream14.dropWhile(x -> x/4 == 0);
        System.out.println(Arrays.toString(intStream15.toArray()));

        // boxed(): Used to change IntStream to Stream<Integer>
        // Similarly for LongStream and DoubleStream
        Stream<Integer> intStream16 = Arrays.stream(new int[]{1,2,3}).boxed();

        // noneMatch(IntPredicate):
        // Verify whether an integer is present in the stream
        // if none of the element matches, return true. else, return false
        boolean noneMatchEle = Arrays.stream(new int[]{1,2,3,4,5}).noneMatch(x -> x==6);
        System.out.println(noneMatchEle);

        // map uses IntUnaryOperator for IntStream and returns IntStream
        IntStream intStream17 = IntStream.of(1,2,3,4,5);
        IntStream intStream18 = intStream17.map(x -> x+4);
        System.out.println(Arrays.toString(intStream18.toArray()));

        // filter uses IntPredicate for IntStream
        IntStream intStream19 = IntStream.of(1,2,3,4,5);
        IntStream intStream20 = intStream19.filter(x -> x>=3);
        System.out.println(Arrays.toString(intStream20.toArray()));

        // reduce uses IntBinaryOperator for IntStream
        // 2 overloads
        // reduce(identity, IntBinaryOperator) returns int
        // identity acts as a first argument in reduction process
        // and acts as a default o/p when stream is empty
        // reduce(IntBinaryOperator) returns OptionalInt
        IntStream intStream21 = IntStream.of(1,2,3,4,5);
        OptionalInt reduced1 = intStream21.reduce((x,y)->x+y);
        System.out.println(reduced1);
        System.out.println(reduced1.getAsInt());
        IntStream intStream22 = IntStream.of(1,2,3,4,5);
        int reduced2 = intStream22.reduce(2,(x,y)->x+y);
        System.out.println(reduced2); // 17 -> 2+(1+2+3+4+5) = 17
        IntStream intStream23 = IntStream.empty(); // Stream is empty
        System.out.println(intStream23.reduce(23,(x,y)->x+y));
        // identity value "23" is returned as stream is empty

        // sorted() -> sort stream elements
        IntStream intStream24 = IntStream.of(3,2,1);
        IntStream sortedIntStream24 = intStream24.sorted();
        System.out.println(Arrays.toString(sortedIntStream24.toArray()));

        // peek(IntConsumer) -> peek() without any terminal operation will not produce
        // any output.
        // peek() actually used for debugging
        IntStream intStream25 = IntStream.of(1,2,3,4);
        int ssum = intStream25.peek(System.out::println).sum();
        System.out.println(ssum);

        // takeWhile() -> Opposite of dropWhile()
        IntStream intStream26 = IntStream.of(1,2,3,4,5);
        IntStream intStream27 = intStream26.takeWhile(x->x<3);
        System.out.println(Arrays.toString(intStream27.toArray()));

        // forEach()
        IntStream intStream28 = IntStream.range(2,6);
        intStream28.forEach(x-> System.out.println(x));

        // forEachOrdered
        IntStream intStream29 = IntStream.range(1,4);
        intStream29.forEachOrdered(x -> System.out.println(x));

        // asLongStream() and asDoubleStream() -> Only available for IntStream objects
        LongStream longStream = IntStream.of(1,2).asLongStream();
        DoubleStream doubleStream = IntStream.of(1,2).asDoubleStream();

        // mapToLong(), mapToDouble() and mapToObject()
        // These converts IntStream objects to LongStream, DoubleStream and ObjectStream
        // after map operation
        LongStream longStream1 = IntStream.of(1,2).mapToLong(x->x+2);
        DoubleStream doubleStream1 = IntStream.of(1,2).mapToDouble(x->x*2);
        Stream<Object> objectStream = IntStream.of(1,2,3,4,5,6,7).mapToObj(x->x*2);

        System.out.println("*************Streams on Map collections**********");
        Stream<String> mapStream1 = new HashMap<>(Map.of("one",1,"two",2)).keySet().stream();
        System.out.println(mapStream1.collect(Collectors.toList()));
        Stream<Integer> mapStream2 = new HashMap<>(Map.of("one",1,"two",2)).values().stream();
        System.out.println(mapStream2.collect(Collectors.toList()));
        Stream<Map.Entry<String,Integer>> mapStream3 = new HashMap<>(Map.of("one",1,"two",2)).entrySet().stream();
        System.out.println(mapStream3.collect(Collectors.toList()));

        System.out.println("******************map() vs flatMap()***************************");
        // flatMap() = map() + flatten procedure
        // map() is used for one-to-one mapping
        // if output data produced is single object.
        // if output generated is multiple and need to store in linear fashion, use flatMap
        // map() takes Stream<T> and returns Stream<R>
        // flatMap() takes Stream<Stream<T>> as input and returns Stream<R>
        Stream<Integer> s1 = Stream.of(1,2,3,4,5);
        List<Integer> c1 = s1.map(x -> x+10).collect(Collectors.toList());
        System.out.println(c1);

        // if the data is 2-D array like
        List<List<Integer>> list1 = new ArrayList<>();
        list1.add(new ArrayList<>(List.of(1,2,3)));
        list1.add(new ArrayList<>(List.of(4,5,6)));
        list1.add(new ArrayList<>(List.of(7,8,9)));

        // If we use map() here,
        List<List<Integer>> c2 = list1.stream().map(x -> x).collect(Collectors.toList());
        System.out.println(c2);

        // Use flatMap() to store as List<Integer> instead of List<List<Integer>>
        List<Integer> c3 = list1.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
        System.out.println(c3);
    }
}
