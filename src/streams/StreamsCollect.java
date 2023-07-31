package streams;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
// collect method syntax: R collect(T,A,R)
// collect() method has 2 method overloads
// 1) collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
// and returns 'R'
// 2) collect(Collector<? super T, A, R>) and returns 'R'
// T(Supplier) -> A function that creates a new mutable container of type 'R' and returns that container whenever called
// A(Accumulator) -> This adds elements to the result container 'R' provided by supplier 'T'
// R(Combiner) -> This function takes one or more partial result containers produced by accumulators
// and merges them. Merging process: This takes all elements from the second partial result container
// and adds them to the first partial result container. Finally, It returns this container to the
// collect() method which again in turn returns the container of type 'R'
// NOTE: Accumulator and Combiner should be of same type
// In Stream API, We use "Collectors" class static methods which returns "Collector" type.

// Flow:
// 1) "Collectors" class static methods returns "Collector" type to "collect" method
// 2) After receiving "Collector<T,A,R>" by collect() method, collect() method returns 'R' from it.
public class StreamsCollect {
    public static void main(String[] args) {
        System.out.println("*******************toList()******************");
        List<Integer> list1 = new ArrayList<>(List.of(1,2,3,4,4,5));
        Stream<Integer> stream1 = list1.stream().map(x->x*2);
        List<Integer> list2 = stream1.collect(Collectors.toList());
        System.out.println(list2);

        System.out.println("****************toSet()*******************");
        Set<String> set1 = new HashSet<>(Set.of("a","b","c"));
        Set<String> stream2 = set1.stream().map(x->x.concat("apple")).collect(Collectors.toSet());
        System.out.println(stream2);

        System.out.println("*********averagingInt(), averagingDouble() and averagingLong()******************");
        Stream<String> stream3 = Stream.of("1","2","3");
        Double intAvg = stream3.collect(Collectors.averagingInt(Integer::parseInt));
        System.out.println(intAvg);
        Stream<Integer> stream4 = Stream.of(1,2,3);
        Double doubleAvg = stream4.collect(Collectors.averagingDouble(Double::new));
        System.out.println(doubleAvg);
        Stream<String> stream5 = Stream.of("1","2","3");
        Double longAvg = stream5.collect(Collectors.averagingLong(Long::parseLong));
        System.out.println(longAvg);

        System.out.println("********************counting()********************");
        // counting returns count of elements in a stream as Long data type
        Stream<Integer> stream6 = Stream.of(1,2,3,4,5,4,3,2,1,2,3,1,2,3);
        Long stream6Count = stream6.collect(Collectors.counting());
        // The above line is same as stream6.count();
        System.out.println(stream6Count);

        System.out.println("**************************joining()****************************");
        // There are 3 overloads
        // 1) joining()
        // 2) joining(CharSequence delimiter) -> delimiter to be used between each element
        // 3) joining(CharSequence delimiter,CharSequence prefix,CharSequence suffix)
        // prefix: The sequence of characters to be used at the beginning of joined result
        // suffix: The sequence of characters to be used at the end of joined result
        String joinedString1 = Stream.of('a','b','c','d','e').map(String::valueOf).collect(Collectors.joining());
        System.out.println(joinedString1);
        String joinedString2 = Stream.of('a','b','c','d','e').map(String::valueOf).collect(Collectors.joining("#"));
        System.out.println(joinedString2);
        String joinedString3 = Stream.of('a','b','c','d','e').map(String::valueOf).collect(Collectors.joining("@","[","]"));
        System.out.println(joinedString3);

        System.out.println("**********************mapping()****************************");
        // mapping(Function, Collector)
        Stream<String> stream7 = Stream.of("apple","banana","cherry");
        List<Integer> mappedList = stream7.collect(Collectors.mapping(x -> x.length(), Collectors.toList()));
        System.out.println(mappedList);

        System.out.println("***********************groupingBy()*************************");
        // 3 overloads
        // groupingBy(classifier)
        // groupingBy(classifier, collector)
        // groupingBy(classifier, supplier, collector)
        // classifier: maps input elements to map keys
        // collector: It is the downstream reduction function. By default, Collectors.toList() is used which causes the grouped elements into a List.
        // supplier: provides a new empty Map into which the results will be inserted. By default, HashMap::new is used. We can use other maps such as TreeMap, LinkedHashMap or ConcurrentMap to insert additional behavior in the grouping process such as sorting.

        Stream<Integer> stream8 = Stream.of(10,20,30,40,50,10,20,30,40,50,10,20,40,30,10,30);
        Map<Integer,List<Integer>> group1 = stream8.collect(Collectors.groupingBy(Function.identity()));
        System.out.println(group1);

        Stream<String> stream9 = Stream.of("yokesh","kusuma","narasimhulu","meenaka","indrani");
        Map<Integer,List<String>> group2 = stream9.collect(Collectors.groupingBy(x -> x.length(), Collectors.toList()));
        System.out.println(group2);

        // Storing map without supplier, so java uses HashMap
        Stream<Integer> stream10 = Stream.of(10,20,30,40,50,10,20,30,40,50,10,20,40,30,10,30);
        Map<Integer,Long> group3 = stream10.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(group3); // O/P: {50=2, 20=3, 40=3, 10=4, 30=4}
        // We can customize our Map by passing supplier, So I will use TreeMap so that we can sort the o/p
        Map<Integer,Long> increasingGroup = Stream.of(10,20,30,40,50,10,20,30,40,50,10,20,40,30,10,30).collect(Collectors.groupingBy(x->x,TreeMap::new,Collectors.counting()));
        System.out.println(increasingGroup); // O/P: {10=4, 20=3, 30=4, 40=3, 50=2} which is sorted

        System.out.println("**********************filtering()*************************");
        Stream<String> stream11 = Stream.of("tokyo city","delhi","london city","singapore city","sydney","Mica city","chicago", "cape city","nevada city");
        List<String> filter1 = stream11.collect(Collectors.filtering(x -> x.startsWith("s"), Collectors.toList()));
        System.out.println(filter1);
        // filtering() with groupingBy()
        Stream<String> stream12 = Stream.of("tokyo city","delhi","london city","singapore city","sydney","Mica city","chicago", "cape city","nevada city");
        Map<Integer,List<String>> filterGroup1 = stream12.collect(Collectors.groupingBy(x -> x.length(), Collectors.filtering(x -> x.contains("city"), Collectors.toList())));
        System.out.println(filterGroup1);

        System.out.println("******************mapping() using groupingBy()**********************");
        Stream<Integer> stream13 = Stream.of(1,2,3,4,5,6,7,8,9,10);
        Map<Integer, List<Integer>> mapGroup = stream13.collect(Collectors.groupingBy(x -> x, Collectors.mapping(x -> x+2, Collectors.toList())));
        System.out.println(mapGroup);

        System.out.println("*******************summingInt(), summingLong(), summingDouble()********************");
        int[] intArray = {1,2,3,4,5};
        long[] longArray = {1111L,2222L,3333L,4444L,5555L};
        double[] doubleArray = {11.11,22.22,33.33,44.44,55.55};
        Integer sum1 = Arrays.stream(intArray).boxed().collect(Collectors.summingInt(x -> x));
        System.out.println(sum1);
        Long sum2 = Arrays.stream(longArray).boxed().collect(Collectors.summingLong(x -> x));
        System.out.println(sum2);
        Double sum3 = Arrays.stream(doubleArray).boxed().collect(Collectors.summingDouble(x -> x));
        System.out.println(sum3);

        System.out.println("****************maxBy() and minBy()***********************");
        Stream<Integer> stream14 = Stream.of(1,2,3,4,5,6);
        Optional<Integer> maxi = stream14.collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println(maxi);
        Stream<Integer> stream15 = Stream.of(1,2,3,4,5,6);
        Optional<Integer> mini = stream15.collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println(mini);

        System.out.println("***********************reducing()***************************");
        // reducing(identity, BinaryOperator)
        // reducing(BinaryOperator)
        // reducing(identity, Function, BinaryOperator)
        Stream<Integer> stream16 = Stream.of(1,2,3,4,5);
        Integer reduced1 = stream16.collect(Collectors.reducing(10,(x,y)->x+y)); // with identity
        System.out.println(reduced1); // 10 +(1+2+3+4+5) = 25
        Stream<String> stream17 = Stream.of("yokesh","java","python");
        Optional<String> reduced2 = stream17.collect(Collectors.reducing((x,y)->x+y));
        System.out.println(reduced2.get());
        Stream<Integer> stream18 = Stream.of(1,2);
        Integer reduced3 = stream18.collect(Collectors.reducing(10,x->x+2,(x,y)->x+y));
        System.out.println(reduced3);
    }
}
