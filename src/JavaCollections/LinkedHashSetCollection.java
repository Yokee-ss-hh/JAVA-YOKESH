package JavaCollections;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetCollection {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(10);
        set.add(11);
        set.add(100);
        set.add(1);
        set.add(5);
        System.out.println(set); // Insertion ordering is preserved
    }
}
