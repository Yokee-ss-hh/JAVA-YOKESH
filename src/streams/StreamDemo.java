package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class StreamDemo {
    public static void main(String[] args) {
        // max(Comparator<T> comparator)
        Stream<Integer> s1 = Stream.of(1,2,3,4,5);
        Optional<Integer> s1Max = s1.max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o1);
            }
        });
        System.out.println(s1Max.get());

        // min(Comparator<T> comparator)
        Stream<Integer> s2 = Stream.of(1,2,3);
        Optional<Integer> s2Min = s2.min(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(s2Min.get());

        // count()
        Stream<Integer> s3 = Stream.of(1,2,3);
        long s3Count = s3.count();
        System.out.println(s3Count);

        // distinct()
        Stream<Integer> s4 = Stream.of(1,2,1,2,4,1,3);
        Stream<Integer> s4Distinct = s4.distinct();
        System.out.println(Arrays.toString(s4Distinct.toArray()));

        // sorted()
        // sorted(Comparator<T> comparator)
        Stream<Integer> s5 = Stream.of(99,9,12,1,-32,-1111,0,44);
        Stream<Integer> s5Sorted = s5.sorted();
        System.out.println(Arrays.toString(s5Sorted.toArray()));

        Stream<Integer> s6 = Stream.of(99,9,12,1,-32,-1111,0,44);
        Stream<Integer> s6SortedInDecreasingOrder = s6.sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(Arrays.toString(s6SortedInDecreasingOrder.toArray()));

        // map()
        Stream<String> s7 = Stream.of("yokesh","madhu","ram","ravan");
        Stream<String> s7Mapped = s7.map(x -> x.toUpperCase());
        s7Mapped.forEach(System.out::println);

        // mapToInt()
        Stream<String> s8 = Stream.of("a","b","c");
        IntStream s8IntStream = s8.mapToInt(x -> x.charAt(0));
        System.out.println(Arrays.toString(s8IntStream.toArray()));
        // Note char can convert to int on direct assignment

        // mapToLong()
        Stream<Double> s9 = Stream.of(12.234,121.121,123153.5643,909.423);
        LongStream s9LongStream = s9.mapToLong(x -> (long)x.doubleValue());
        System.out.println(Arrays.toString(s9LongStream.toArray()));

        // mapToDouble
        Stream<Long> s10 = Stream.of(955092L,829726l,970387l);
        DoubleStream s10DoubleStream = s10.mapToDouble(x -> x.longValue());
        System.out.println(Arrays.toString(s10DoubleStream.toArray()));

        // filter(Predicate<T> predicate)
        Stream<Integer> s11 = Stream.of(2,12,23,11,7,9,13);
        Stream<Integer> s11Filtered = s11.filter(x -> x%2 == 0);
        System.out.println(Arrays.toString(s11Filtered.toArray()));

        // reduce(BinaryOperator<T> binaryOperator)
        // reduce(Integer identity, BinaryOperator<T> binaryOperator)
        Stream<String> s12 = Stream.of("java","python","c++");
        Optional<String> s12Reduced = s12.reduce((x,y)->x+y);
        System.out.println(s12Reduced.get());

        Stream<Integer> s13 = Stream.of(1,3,5,7,9);
        Integer s13Reduced = s13.reduce(10, (x, y) -> x * y);
        System.out.println(s13Reduced);

        // allMatch(Predicate<T> predicate)
        Stream<Integer> s14 = Stream.of(10,20,30,40,50);
        Boolean s14AllMatch = s14.allMatch(x -> x%2==0);
        System.out.println(s14AllMatch);

        // anyMatch(Predicate<T> predicate)
        Stream<String> s15 = Stream.of("hastinapur","bhagyanagar","magadha","montreal","holand");
        Boolean s15AnyMatch = s15.anyMatch(x -> x.startsWith("h"));
        System.out.println(s15AnyMatch);

        // noneMatch(Predicate<T> predicate)
        Stream<String> s16 = Stream.of("its ok","oh my god","asap");
        Boolean s16NoneMatch = s16.noneMatch(x -> x.length()>10);
        System.out.println(s16NoneMatch);

        // takeWhile(Predicate<T> predicate)
        Stream<Integer> s17 = Stream.of(12,21,13,31,44,66,10011);
        Stream<String> s17Strings = s17.map(x->x.toString()).takeWhile(x->x.length()==2);
        System.out.println(Arrays.toString(s17Strings.toArray()));

        // dropWhile(Predicate<T> predicate)
        Stream<Integer> s18 = Stream.of(12,21,13,31,44,66,10011);
        Stream<String> s18Strings = s18.map(x->x.toString()).dropWhile(x->x.length()==2);
        System.out.println(Arrays.toString(s18Strings.toArray()));

        // findFirst() return Optional<T> if stream is not empty
        // findFirst() return Optional.empty if stream is empty
        Stream<Integer> s19 = Stream.of(1,2,3,4,5);
        Optional<Integer> s19FindFirst = s19.findFirst();
        System.out.println(s19FindFirst.get());

        Stream<Integer> s20 = Stream.empty();
        Optional<Integer> s20EmptyFindFirst = s20.findFirst();
        System.out.println(s20EmptyFindFirst);

        // findAny() return Optional<T> if stream is not empty, Optional.empty if stream is empty
        // It chooses random element from stream
        Stream<Integer> s21 = Stream.of(312,112,12311);
        Optional<Integer> s21FindAny = s21.findAny();
        System.out.println(s21FindAny.get());

        Stream<Integer> s22 = Stream.empty();
        Optional<Integer> s22EmptyFindAny = s22.findAny();
        System.out.println(s22EmptyFindAny);

        // forEach(Consumer<T> consumer) when used after parallel() method will not guarantee the original order
        // forEachOrdered(Consumer<T> consumer) when used after parallel() method will guarantee the original order
        Stream.of(1,2,3,4,5).parallel().forEach(System.out::println);
        Stream.of(1,2,3,4,5).parallel().forEachOrdered(System.out::println);

        System.out.println("*********");
        // map(Function<T,R> function) and returns Stream<R> vs flatMap(Function<T,Stream<R>> function) and returns Stream<R>
        List<List<String>> fruits = new ArrayList<>();
        fruits.add(new ArrayList<>(List.of("Apple","Banana")));
        fruits.add(new ArrayList<>(List.of("Cherry","Mango")));

        List<List<Integer>> fruitsLengthsUsingMap = fruits.stream().map(x -> x.stream()).map(y -> y.map(z -> z.length()).collect(Collectors.toList())).collect(Collectors.toList());
        List<Integer> finalFruitsLengthsUsingMap = new ArrayList<>();
        for(List l:fruitsLengthsUsingMap){
            for(Object l1 : l){
                finalFruitsLengthsUsingMap.add((Integer) l1);
            }
        }
        System.out.println(finalFruitsLengthsUsingMap);

        List<Integer> fruitsLengthsUsingFlatMap = fruits.stream().flatMap(x -> x.stream()).map(x->x.length()).collect(Collectors.toList());
        System.out.println(fruitsLengthsUsingFlatMap);

        // If there is a 2-D array with name hobbies
        // hobbies.stream().map(x->x.stream()) returns Stream<Stream<T>> objects
        // hobbies.stream().flatMap(x->x.stream()) returns Stream<T> objects
        // This is the main difference. flatMap flattens 2-D array stream to 1-D array stream implicitly
    }
}
