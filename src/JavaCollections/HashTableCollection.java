package JavaCollections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableCollection {
    public static void main(String[] args) {
        // Constructors are:
        // 1) Default constructor() which takes 0 parameters and provides initial capacity as 11 and
        // load factor as 0.75
        // 2) HashTable(initial capacity) -> Only takes initial capacity as parameter
        // 3) HashTable(Map<T,T>) -> Takes Map interface object as parameter
        System.out.println("*************put, putAll and get*******************");
        Hashtable<String,Integer> ht1 = new Hashtable<>(new HashMap<>(Map.of("one",1,"two",2)));
        System.out.println(ht1);

        Hashtable<String,String> ht2 = new Hashtable<>();
        ht2.put("name","yokesh");
        ht2.putAll(Map.of("age","24","designation","software engineer"));
        System.out.println(ht2);

        System.out.println(ht2.get("remote")); // null as this key is not present in ht2
        System.out.println(ht2.get("designation"));

        System.out.println("***************remove***************");
        Hashtable<String,Integer> ht3 = new Hashtable<>(Map.of("one",1,"two",2));
        System.out.println(ht3.remove("two")); // returns value of the removable key
        System.out.println(ht3.remove("three")); // returns "null" as this key is not
        // present in hashtable

        // Similarly all other operations are available with methods of hash map
    }
}
