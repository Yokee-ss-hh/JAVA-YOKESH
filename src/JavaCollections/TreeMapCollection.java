package JavaCollections;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreeMapCollection {
    public static void main(String[] args) {

        System.out.println("***************TreeMap Constructors**************");
        // 1) Constructor using Map.of()
        SortedMap<Integer,String> tMap1 = new TreeMap<>(Map.of(3,"three",1,"one",2,"two"));
        System.out.println(tMap1); // Will be sorted in ascending order

        // 2) Constructor using existing Map interfaced implemented classes such as HashMap and LinkedHashMap
        Map<String,String> hm = new HashMap<>();
        hm.put("One","1");
        hm.put("Nine","9");
        hm.put("Eight","8");
        hm.put("Two","2");
        SortedMap<String,String> tMap2 = new TreeMap<>(hm);
        System.out.println(tMap2);

        // 3) Constructor using existing Sorted Map interfaced implemented class such as TreeMap
        TreeMap<Integer,String> tm = new TreeMap<>();
        tm.put(20,"twenty");
        tm.put(200,"two hundred");
        tm.put(1,"one");
        TreeMap<Integer,String> tMap3 = new TreeMap<>(tm);
        System.out.println(tMap3);

        // NOTE: There is no constructor using initial capacity as TreeMap is constructed using BinaryTree

        // Passing comparator to change ordering to descending
        Comparator<Integer> descendingComparator = (x,y) ->{
            if(x < y){
                return 1;
            }
            else if(x == y){
                return 0;
            }
            else{
                return -1;
            }
        };
        TreeMap<Integer,String> descendingTreeMap = new TreeMap<>(descendingComparator);
        descendingTreeMap.put(222,"Two twenty two");
        descendingTreeMap.put(100,"Hundred");
        descendingTreeMap.put(20,"twenty");
        descendingTreeMap.put(155,"one fifty five");
        System.out.println(descendingTreeMap);

        // 5) Constructor which uses comparator using inner class procedure
        Comparator<String> descendingComparator1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int dummy = o1.compareTo(o2);
                if(dummy < 1){
                    return 1;
                }
                else if(dummy == 0){
                    return 0;
                }
                else{
                    return -1;
                }
            }
        };
        TreeMap<String,String> descendingTreeMap1 = new TreeMap<>(descendingComparator1);
        descendingTreeMap1.put("one","1");
        descendingTreeMap1.put("two","2");
        descendingTreeMap1.put("three","3");
        System.out.println(descendingTreeMap1);

        // TreeMap will not allow key as "null" but allows multiple values as "null"
        SortedMap<Integer,Integer> tMap4 = new TreeMap<>();
        // tMap4.put(null,1); -> Throws exception as TreeMap don't allow null keys
        tMap4.put(1,null);
        tMap4.put(2,null);
        tMap4.put(3,3);
        tMap4.put(4,4);
        System.out.println(tMap4);

        // TreeMap using Map.entry() and Map.ofEntries() methods
        Map.Entry<String,String> t1 = Map.entry("happy","happy");
        Map.Entry<String,String> t2 = Map.entry("one","one");
        Map<String,String> t3 = Map.ofEntries(t1,t2);
        SortedMap<String,String> mapUsingMapEntryClass = new TreeMap<>(t3);
        System.out.println(mapUsingMapEntryClass);
    }
}
