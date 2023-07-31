package JavaCollections;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreeSetCollection {
    public static void main(String[] args) {

        System.out.println("******************Constructors***********************");
        // 1) TreeSet which takes Comparator
        SortedSet<Integer> s1 = new TreeSet<Integer>();
        s1.add(10);
        s1.add(7);
        s1.add(2);
        s1.add(99);
        System.out.println(s1); // Elements in ascending order

        SortedSet<Integer> s2 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2){
                    return 1;
                }
                else if(o1 == o2){
                    return 0;
                }
                else{
                    return -1;
                }
            }
        });
        s2.add(10);
        s2.add(7);
        s2.add(2);
        s2.add(99);
        System.out.println(s2); // Elements in descending order

        // 2) TreeSet() which takes any class which implement Collection
        SortedSet<Integer> s3 = new TreeSet<>(new ArrayList<>(List.of(1,4,3,7,9,2)));
        System.out.println(s3);

        // 3) TreeSet() which takes another SortedSet as parameter
        SortedSet<Integer> s4 = new TreeSet<>(s3);
        System.out.println(s4);

        System.out.println("**********headSet() and tailSet()***************");
        // headSet() takes element and return all elements less than the element
        // tailSet() takes element and return all elements greater than or equal to the element
        SortedSet<Integer> s5 = new TreeSet<>();
        s5.add(99);
        s5.add(88);
        s5.add(9);
        s5.add(1);
        s5.add(44);
        s5.add(66);
        s5.add(10);
        System.out.println(s5);
        SortedSet<Integer> s6 = s5.headSet(66);
        System.out.println(s6);
        SortedSet<Integer> s7 = s5.tailSet(66);
        System.out.println(s7);
        // What if element is not present in Set ?
        SortedSet<Integer> s8 = s5.headSet(199);
        System.out.println(s8);
        // If element provided is not in set, It simply returns complete set

        System.out.println("****************first() and last()*************");
        // first() returns lowest element in the set
        // last() returns highest element in the set
        SortedSet<Integer> s9 = new TreeSet<>();
        s9.add(9);
        s9.add(2);
        s9.add(3);
        s9.add(12);
        s9.add(-99);
        s9.add(-3);
        System.out.println(s9.first());
        System.out.println(s9.last());
    }
}
