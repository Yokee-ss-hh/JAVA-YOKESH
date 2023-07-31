package JavaCollections;

import java.util.*;

public class HashSetCollection {
    public static void main(String[] args) {
        System.out.println("***********Constructors**************");
        // 1. HashSet with Set.of() factory method elements
        Set<Integer> s1 = new HashSet<>(Set.of(1,2,3,4,5));
        // Set.of() takes unique elements only in HashSet() constructors
        System.out.println(s1);

        // 2. HashSet default / empty constructor
        // Takes initial capacity as 16 with load factor of 0.75
        Set<Integer> s2 = new HashSet<>();
        s2.add(10);
        s2.add(10);
        s2.add(20);
        System.out.println(s2);

        // 3. HashSet constructor which takes any Collection implemented class
        Set<Integer> s3 = new HashSet<>(new LinkedList<>(List.of(1,2,3,4,5)));
        System.out.println(s3);

        // 4. HashSet constructor which takes initial capacity and load factor
        Set<String> s4 = new HashSet<>(12,0.5f);

        // 5. HashSet constructor which takes initial capacity
        Set<String> s5 = new HashSet<>(15);

        System.out.println("**************Adding elements**************");
        HashSet<Integer> s6 = new HashSet<>();
        s6.add(12);
        s6.addAll(new ArrayList<>(List.of(1,2,19,20,1,11,2,19)));
        System.out.println(s6); // removed duplicates

        System.out.println("************removing elements****************");
        HashSet<String> s7 = new HashSet<>();
        s7.add("apple");
        s7.addAll(List.of("banana","apple","cherry","grape","banana","olive","orange"));
        System.out.println(s7);
        s7.remove("apple");
        System.out.println(s7);
        s7.removeAll(new ArrayList<>(List.of("banana","cherry")));
        System.out.println(s7);
        // If element that is passed in remove() and removeAll() is not in set, Java ignores them
        s7.remove("guava");
        System.out.println(s7);
        s7.removeAll(new ArrayList<>(List.of("olive","sapota")));
        System.out.println(s7); // removes "olive" and ignores "sapota"

        System.out.println("**************clear, isEmpty, size, contains*****************");
        Set<Float> s8 = new HashSet<>();
        System.out.println(s8.isEmpty());
        System.out.println(s8.size());
        s8.add(12.21f);
        s8.add(1.23f);
        System.out.println(s8.isEmpty());
        System.out.println(s8.size());
        System.out.println(s8.contains(1.23f));
        System.out.println(s8.contains(98.866f));
        s8.clear();
        System.out.println(s8);

        System.out.println("*************Ordering of elements in HashSet****************");
        Set<Integer> evenNumbers = new HashSet<>();
        evenNumbers.add(12);
        evenNumbers.add(2);
        evenNumbers.add(10);
        evenNumbers.add(4);
        evenNumbers.add(8);
        evenNumbers.add(6);
        evenNumbers.add(null);
        evenNumbers.add(null);
        for(Integer i: new int[]{1,2,3,4,5,6,7,8,9,10}) {
            evenNumbers.add(i);
        }
        System.out.println(evenNumbers);

        System.out.println("******************toArray()**********************");
        // toArray() returns Object[]
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(10);
        hashSet.add(5);
        Object[] tempArray = hashSet.toArray();
        System.out.println(Arrays.toString(tempArray));
    }
}
