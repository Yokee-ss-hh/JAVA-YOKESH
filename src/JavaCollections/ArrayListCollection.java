package JavaCollections;

// List is an interface extending from Collection interface
// List interface is implemented by ArrayList, LinkedList, Vector
// Stack class extends Vector class

import java.util.ArrayList;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class ArrayListCollection {
    public static void main(String[] args) {
        // Default capacity of ArrayList is 10
        // When ArrayList is full, Then
        // New capacity = (Old capacity * 3/2)+1
        List<Integer> list1 = new ArrayList<>(3);

        // 1) add(data) and add(index,data)
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println(list1);
        list1.add(0, 0);
        System.out.println(list1);


        // 2) modify List using set(index, newData)
        list1.set(3, 33);
        System.out.println(list1);

        // 3) remove data from list using remove(object), remove(index)
        List<String> stringList = new ArrayList<>(List.of("yokesh","java"));
        list1.remove(0);
        System.out.println(list1);
        stringList.remove("java");
        System.out.println(stringList);

        // 4) get data from list using get(index)
        // Throws exception when index < 0 and index is out of range
        Integer element = list1.get(2);
        System.out.println(element);
        System.out.println(list1);

        // 5) addAll(Collection), addAll(index, Collection)
        List<Integer> dummyList = new ArrayList<>(List.of(11,12,13));
        list1.addAll(dummyList);
        System.out.println(list1);

        list1.addAll(1,dummyList);
        System.out.println(list1);

        // 6) contains(object)
        System.out.println(list1.contains(33));
        System.out.println(list1.contains(100));

        // 7) indexOf() and lastIndexOf()
        System.out.println(list1.indexOf(11));
        System.out.println(list1.lastIndexOf(11));

        // 8) containsAll(Collection collection)
        System.out.println(list1.containsAll(new ArrayList<>(List.of(11,12,13))));
        System.out.println(list1.containsAll(new ArrayList<>(List.of(1,2))));

        // 9) equals(): Two lists should be of same size and corresponding elements should be equal
        System.out.println(new ArrayList<>(List.of(1,2,3)).equals(new ArrayList<>(List.of(1,2,3,4))));
        System.out.println(new ArrayList<>(List.of(1,2,3)).equals(new ArrayList<>(List.of(3,2,1))));
        System.out.println(new ArrayList<>(List.of(1,2,3)).equals(new ArrayList<>(List.of(1,2,3))));

        // 10) clear(): clears elements in the list but the data structure will be persisted
        List<Long> longList = new ArrayList<>(List.of(12345L,231412L));
        System.out.println(longList);
        longList.clear();
        System.out.println(longList);

        // 11) isEmpty()
        System.out.println(longList.isEmpty());

        // 12) toArray()
        System.out.println(Arrays.toString(list1.toArray()));

        // 13) hashCode()
        System.out.println(list1.hashCode());

        // 14) subList(fromIndex, toIndex)
        List<Integer> mySubList = list1.subList(2,5);
        System.out.println(mySubList);

        // 15) sort()
        Comparator<Integer> comparator = (a,b) -> a.compareTo(b);
        List<Integer> toBeSorted = new ArrayList<>(List.of(5,4,2,3,1));
        toBeSorted.sort(comparator);
        System.out.println(toBeSorted);

        // 16) predicate()
        Predicate<Integer> predicate = (x) -> {
            if(x % 2 == 0){
                return true;
            }
            else{
                return false;
            }
        };
        List<Integer> pred = new ArrayList<>(List.of(1,2,3,4,5,6));
        pred.removeIf(predicate);
        System.out.println(pred);

        // 17) forEach()
        pred.forEach(x -> System.out.println(x));
        // OR
        // forEach() takes consumer ,We can explicitly define consumer as
        Consumer<Integer> consumer = (x) -> System.out.println(x);
        pred.forEach(consumer);

        // 18) getClass()
        System.out.println(list1.getClass());

        // 19) replaceAll()
        List<Integer> toBeReplaced = new ArrayList<>(List.of(1,2,3,4,5));
        // replaceAll() takes UnaryOperator as parameter
        UnaryOperator<Integer> unaryOperator = (x) -> {
            return x+2;
        };
        toBeReplaced.replaceAll(unaryOperator);
        System.out.println(toBeReplaced);

        // 20) iterator()
        Iterator<Integer> iterator = toBeReplaced.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // 21) listIterator()
        Iterator<Integer> iterator1 = toBeReplaced.listIterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        // 22) listIterator(index)
        Iterator<Integer> iterator2 = toBeReplaced.listIterator(2);
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

        // 23) toString()
        System.out.println(list1.toString());

        // 24) retainAll(): retains the elements that is in the provided list
        // and removes other elements
        List<Integer> retainList = new ArrayList<>(List.of(1,2,3,4,5,6));
        retainList.retainAll(new ArrayList<>(List.of(1,3,5)));
        System.out.println(retainList);

        // 25) removeAll(): removes all elements specified in the list
        // If specified elements are not in list, Then it will ignore and not throws
        // any exception
        List<Integer> numbers1 = new ArrayList<>(List.of(1,2,3,4,5,6,7));
        numbers1.removeAll(new ArrayList<>(List.of(9,10)));
        System.out.println(numbers1);

        List<Integer> numbers2 = new ArrayList<>(List.of(1,2,3,4,5));
        numbers2.removeAll(new ArrayList<>(List.of(1,2)));
        System.out.println(numbers2);

        // methods from ArrayList
        ArrayList arrayList = new ArrayList(Arrays.asList(1,2,3,4,5));
        ArrayList clonedArrayList = (ArrayList) arrayList.clone(); // makes shallow copy
        System.out.println(clonedArrayList);
    }
}
