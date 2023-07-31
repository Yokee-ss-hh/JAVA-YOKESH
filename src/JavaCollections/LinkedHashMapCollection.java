package JavaCollections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapCollection {
    public static void main(String[] args) {
        Map<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("grape",1);
        lhm.put("pineapple",2);
        lhm.put("banana",3);
        lhm.put("orange",4);
        System.out.println(lhm); // Ordering is preserved

        Map<String,Integer> hm = new HashMap<>();
        hm.put("grape",1);
        hm.put("pineapple",2);
        hm.put("banana",3);
        hm.put("orange",4);
        System.out.println(hm); // Ordering is not preserved

        // Ordering is the only difference b/w HashMap and LinkedHashMap

        // Constructors of linked hash map are of 5 types, Refer HashMapCollection class for implementations
    }
}
