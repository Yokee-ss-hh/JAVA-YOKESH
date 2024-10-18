package org.dsa.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        Stream<Emp> s1 = Stream.of(new Emp(123,345),new Emp(4324,7567));
        System.out.println(s1.max(new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                if(o1.sal1 < o2.sal1){
                    return -1;
                }
                else if(o1.sal1 == o2.sal1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
        }).get());

        Stream<Emp> s2 = Stream.of(new Emp(123,345),new Emp(4324,7567));
        System.out.println(s2.min(new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                if(o1.sal1 < o2.sal1){
                    return -1;
                }
                else if(o1.sal1 == o2.sal1){
                    return 0;
                }
                else{
                    return 1;
                }
            }
        }).get());

        Stream<Integer> s3 = Stream.of(1,2,3,4,5);
        long streamCount = s3.count();
        System.out.println(streamCount);

        Stream<Integer> s4 = Stream.of(1,2,3,4,5,4,1);
        Stream<Integer> s5 = s4.distinct();
        System.out.println(s5.collect(Collectors.toList()));

        Stream<Integer> s6 = Stream.of(1,2,3,4,5);
        System.out.println(s6.findFirst().get());

        Stream<Integer> s7 = Stream.of(1,2,3,4,5);
        System.out.println(s7.findAny().get());

        Stream<Integer> s8 = Stream.of(1,2,3,4,5);
        boolean flag1 = s8.anyMatch(x->x%2==0);
        System.out.println(flag1);

        Stream<Integer> s9 = Stream.of(2,4,6,5);
        boolean flag2 = s9.allMatch(x->x%2==0);
        System.out.println(flag2);

        Stream<Integer> s10 = Stream.of(1,3,5);
        boolean flag3 = s10.noneMatch(x->x%2==0);
        System.out.println(flag3);

        Stream<Integer> s11 = Stream.of(1,2,3,4,5);
        Stream<Integer> s12 = s11.skip(2);
        System.out.println(s12.collect(Collectors.toList()));

        Stream<Integer> s13 = Stream.of(1,2,3,4,5);
        Stream<Integer> s14 = s13.limit(3);
        System.out.println(s14.collect(Collectors.toList()));

        Stream<Integer> s15 = Stream.of(1,2,3,4,5,6,7,8);
        Stream<Integer> s16 = s15.takeWhile(x->x%2==0);
        System.out.println(s16.collect(Collectors.toList()));

        Stream<Integer> s17 = Stream.of(1,2,3,4,5,6,7,8);
        Stream<Integer> s18 = s17.dropWhile(x->x%2==0);
        System.out.println(s18.collect(Collectors.toList()));

        // peek is used in intermediate operations mainly for debugging purposes.
        // It allows to peek at each element of the stream as it flows through the pipeline without modifying the stream itself.
        // peek takes consumer that performs action on each element.
        Stream<Integer> s19 = Stream.of(1,2,3,4,5);
        System.out.println(s19.map(x->x+2).peek(System.out::println).filter(x->x%2==0).reduce(0,(a,b)->a+b));

        List<List<Integer>> list = List.of(List.of(1,2,3),List.of(4,5,6));
        List<Integer> flatMapResult = list.stream().flatMap(x->x.stream()).collect(Collectors.toList());
        System.out.println(flatMapResult);

        Stream<Integer> s20 = Stream.of(4,8,5,1,2,3);
        Stream<Integer> s21 = s20.sorted();
        System.out.println(s21.toList());

        Stream<Integer> s22 = Stream.of(1,2,3,4,5,6);
        IntStream s23 = s22.mapToInt(Integer::intValue);
        System.out.println(Arrays.toString(s23.toArray()));

        List<List<Integer>> list1 = List.of(List.of(1,2,3),List.of(4,5,6));
        IntStream s24 = list1.stream().flatMapToInt(x->x.stream().mapToInt(Integer::intValue));
        System.out.println(Arrays.toString(s24.toArray()));

        // similarly we have mapToDouble, mapToLong, flatMapToDouble, flatMapToLong

        Stream<Integer> s25 = Stream.of(1,2,3);
        s25.forEach(System.out::println);

        Stream<Integer> s26 = Stream.of(9,8,7);
        s26.forEachOrdered(System.out::println);

        // -------------------------------------------------------------------------------
        // groupingBy() takes Function and groups the stream based on its return type

        Map<Boolean,List<Integer>> map1 = Stream.of(1,2,3,4,5,6).collect(Collectors.groupingBy(x->x%2==0));
        for(Boolean b: map1.keySet()){
            System.out.println(map1.get(b));
        }

        List<Customer> list3 = List.of(
                new Customer("abc",24),
                new Customer("def",45),
                new Customer("ghi",39),
                new Customer("jkl",24),
                new Customer("mno",39));
        Map<Integer,List<Customer>> map2 = list3.stream().collect(Collectors.groupingBy(Customer::getAge));
        for(Integer i: map2.keySet()){
            System.out.println(map2.get(i));
        }

        // By default, groupingBy returns complete object which is a type of stream
        // we can customize the return type of grouping by combining mapping with groupingBy
        List<Customer> list4 = List.of(
                new Customer("abc",24),
                new Customer("def",45),
                new Customer("ghi",39),
                new Customer("jkl",24),
                new Customer("mno",39));
        Map<Integer,List<String>> map3 = list4.stream().collect(Collectors.groupingBy(Customer::getAge,Collectors.mapping(Customer::getName,Collectors.toList())));
        for(Integer i: map3.keySet()){
            System.out.println(map3.get(i));
        }

        List<Integer> list5 = List.of(4,2,3,7,9,11,15);
        System.out.println(list5.stream().collect(Collectors.filtering(x->x%2==0,Collectors.toList())));

        List<Integer> list6 = List.of(9,19,23,43,29,7);
        System.out.println(list6.stream().collect(Collectors.reducing(Integer::sum)).get());
    }
}
