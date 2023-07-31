package JavaCollections;

import java.util.*;
import java.util.function.BiFunction;

public class HashMapCollection{
    public static void main(String[] args) {
        // We can give initial capacity to hash map also
        // new HashMap<>(10);
        Map<String,Integer> hm1 = new HashMap<>(Map.of("a",1,"b",2,"c",3,"d",4));

        System.out.println("**********Map Constructors**********");
        // Constructor 1 -> Can pass capacity and load factor where 0.75 is the default load factor
        Map<String,String> map1 = new HashMap<>(12,0.75f);
        System.out.println(map1);
        // Constructor 2 -> Can use Map.of()
        Map<String,String> map2 = new HashMap<>(Map.of("a","1","b","2"));
        System.out.println(map2);
        // Constructor 3 -> Can use another map
        Map<String,String> map3 = new HashMap<>(new HashMap<>(Map.of("a","a","b","b")));
        System.out.println(map3);
        // Constructor 4 -> Can pass only capacity, Here capacity is user defined and load factor is 0.75
        Map<String,String> map4 = new HashMap<>(12);
        // Constructor 5 -> Can declare empty constructor, Here, Capacity will be 16 and load factor of 0.75 by default
        Map<String,String> map5 = new HashMap<>();


        System.out.println("*********containsKey and containsValue*******");
        System.out.println(hm1.containsKey("a"));
        System.out.println(hm1.containsKey("t"));
        System.out.println(hm1.containsValue(2));
        System.out.println(hm1.containsValue(3));

        System.out.println("**********get and getOrDefault***********");
        // if key present: returns the value
        // if key is not present: returns null
        System.out.println(hm1.get("a"));
        System.out.println(hm1.get("z"));
        // if key is not present in hashmap we can pass default value
        System.out.println(hm1.getOrDefault("z",1000));

        System.out.println("*********put, putAll, putIfAbsent***********");
        // put() adds new key and value to hash map
        // if key is not present in hash map, it returns null
        // if the key already presents, then it will replace the old value with new value and returns old value
        System.out.println(hm1.put("e",5)); // returns null as this key is not present in hm1
        System.out.println(hm1);
        System.out.println(hm1.put("a",11)); // returns 1 as initially "a" has 1, and now we replaced 1 with 11
        System.out.println(hm1);
        // putAll
        Map<String,Integer> hm2 = new HashMap<>(Map.of("f",6,"g",7));
        hm1.putAll(hm2);
        System.out.println(hm1);
        // putIfAbsent
        // returns old value of this key if key is present in hash map
        // if key already present, it will not change old value with new value and returns existing value
        // This is the main difference b/w put() and putIfAbsent()
        System.out.println(hm1.putIfAbsent("h",8));
        System.out.println(hm1);
        System.out.println(hm1.putIfAbsent("g",77));
        System.out.println(hm1);

        System.out.println("*********remove***********");
        // removes key, and it's value from hashmap
        // 1) remove(key) -> removes key value pair and returns value
        // 2) remove(key,value) -> removes key, and it's specified value and returns true
        // if key is not associated with the provided value, it returns false
        System.out.println(hm1.remove("a"));
        System.out.println(hm1);
        System.out.println(hm1.remove("b",22)); // "b" is associated with 2 not 22 , so this will return false
        System.out.println(hm1);

        System.out.println("******replace and replaceAll*********");
        // 1) replace(key,value)
        // 2) replace(key, oldValue, newValue)
        // 3) replaceAll(BiFunction)

        // difference b/w put() and replace() is
        // if key is not present in hashmap, put() creates an entry in hashmap with provided key and value
        // if key is not present in hashmap, replace() will not create an entry with provided key and value
        // i.e, replace only works if key is present in hashmap while set() works if key is present/ not present in map

        // if key is not present , return null
        // else, return the old value
        System.out.println(hm1.replace("t",33)); // returns null
        System.out.println(hm1.replace("e",55)); // returns 5 i.e, old value
        System.out.println(hm1);

        System.out.println(hm1.replace("f",6,66));// returns true as for key "f" the old value if 6
        System.out.println(hm1);
        // if the key don't have a value that is provided, it returns false
        System.out.println(hm1.replace("g",88,77)); // returns false as "g" has a value as 7 not 88
        System.out.println(hm1);

        // replaceAll() uses BiFunction
        Map<String,Integer> hm3 = new HashMap<>(Map.of("yokesh",10,"kusuma",20,"java",30));
        BiFunction<String,Integer,Integer> biFunction = (x,y)->{
          return y*y;
        };
        // BiFunction<Key,OldValue,NewValue>
        hm3.replaceAll(biFunction);
        System.out.println(hm3);

        // We can use lambda instead of passing BiFunction object
        Map<String,Integer> hm4 = new HashMap<>(Map.of("old",2,"new",4));
        hm4.replaceAll((x,y)->y*y);
        System.out.println(hm4);

        System.out.println("********entrySet**********");
        // entrySet() returns Set<Map.Entry<K,V>>
        Map<String,String> hm5 = new HashMap<>(5);
        hm5.put("ABC","abc");
        hm5.put("DEF","def");
        hm5.put("GHI","ghi");
        hm5.put("GHI","Ghi");
        Set<Map.Entry<String,String>> entry = hm5.entrySet();
        System.out.println(entry);
        // Iterating:
        for(Map.Entry<String,String> some_map: entry){
            System.out.println(some_map.getKey());
            System.out.println(some_map.getValue());
        }

        System.out.println("***********keySet()************");
        // keySet() returns Set<K> -> Set of keys
        Map<String,Float> itemPrices = new HashMap<>();
        itemPrices.put("Idly",5.5f);
        itemPrices.put("Dosa",20.0f);
        itemPrices.put("Cheese",32.32f);
        Set<String> itemPricesKeys = itemPrices.keySet();
        System.out.println(itemPricesKeys);
        // Iterating:
        for(String s: itemPricesKeys){
            System.out.println(s);
        }

        System.out.println("************values()************");
        // values() returns Collection of values-> set of values
        Collection<Float> itemPricesValues = itemPrices.values();
        System.out.println(itemPricesValues);
        // iteration:
        for(Float f: itemPricesValues){
            System.out.println(f);
        }

        System.out.println("****************clear()***************");
        Map<Float,Float> hm6 = new HashMap<>();
        hm6.put(1.2f,2.4f);
        hm6.put(2.4f,4.8f);
        System.out.println(hm6);
        hm6.clear();
        System.out.println(hm6);

        System.out.println("***********equals, isEmpty and size****************");
        Map<String,Integer> hm7 = new HashMap<>();
        System.out.println(hm7.isEmpty());
        System.out.println(hm7.size());

        hm7.put("MONDAY",1);
        hm7.put("TUESDAY",2);
        hm7.put("WEDNESDAY",3);

        Map<String,Integer> hm8 = new HashMap<>();
        hm8.put("MONDAY",1);
        hm8.put("TUESDAY",2);
        hm8.put("WEDNESDAY",3);

        System.out.println(hm7.equals(hm8));

        // Changing order in map also considers when equals is used upon
        Map<String,Integer> hm9 = new HashMap<>();
        hm9.put("MONDAY",1);
        hm9.put("WEDNESDAY",3);
        hm9.put("TUESDAY",2);

        System.out.println(hm8.equals(hm9));

        System.out.println("************compute*******************");
        // Works same as put() method
        // compute internally uses put()
        Map<String,String> hm10 = new HashMap<>();
        hm10.put("name","yokesh");
        hm10.put("designation","SE");
        // if key is not present in map, then it class set() internally to create a new key with value we provided
        // using BiFunction
        System.out.println(hm10.compute("age",(x,y)->"twenty")); // returns new value if key is new to the map
        System.out.println(hm10);
        // if key is already present, it will update it
        System.out.println(hm10.compute("designation",(x,y)->"Software Engineer")); // returns new value after
        // replacing old value with new value
        // NOTE: In put() it returns old value after replacing old value with new value
        System.out.println(hm10);

        System.out.println("*****computeIfAbsent and computeIfPresent*************");
        // computeIfPresent() uses BiFunction
        // computeIfAbsent() uses Function

        Map<Integer,Integer> hm11 = new HashMap<>(Map.of(1,10,2,20,3,30));
        System.out.println(hm11.computeIfPresent(3,(x,y)->300));
        System.out.println(hm11); // returns new value 300 as key '3' is present
        System.out.println(hm11.computeIfPresent(4,(x,y)->400));
        System.out.println(hm11); // returns null as key '4' is not present

        System.out.println(hm11.computeIfAbsent(4,(x)->40));
        System.out.println(hm11); // returns 40 which is new value
        System.out.println(hm11.computeIfAbsent(1,(x)->100));
        System.out.println(hm11); // returns 10 as key '1' is already present and hash map will not be updated
        // as key is present in hash map

        System.out.println("*************HashMap can contain 1 null key and multiple null values**********");
        Map<String,Integer> hm12 = new HashMap<>(Map.of("One",1,"Two",2));
        // NOTE: Map.of() does not allow to provide "null"
        // Reason: https://stackoverflow.com/questions/45210398/why-does-map-of-not-allow-null-keys-and-values
        System.out.println(hm12);
        hm12.put(null,3);
        System.out.println(hm12);
        hm12.put("Four",null);
        hm12.put("Five",null);
        System.out.println(hm12);
        hm12.put(null,4); // Adding 2nd null key will override the existing null value
        // Initially, null key has value as '3' , now above line will override null as '4'
        // As, Only 1 null key is allowed in hashmap
        System.out.println(hm12);

        System.out.println("******************Map.entry() and Map.ofEntries()*******************");
        Map.Entry<String,String> yoMap1 = Map.entry("one","one");
        System.out.println(yoMap1.getKey());
        System.out.println(yoMap1.getValue());

        Map.Entry<String,String> yoMap2 = Map.entry("two","two");
        System.out.println(yoMap2.getKey());
        System.out.println(yoMap2.getValue());

        Map<String,String> yoMap3 = Map.ofEntries(yoMap1,yoMap2);
        System.out.println(yoMap3);
    }
}
