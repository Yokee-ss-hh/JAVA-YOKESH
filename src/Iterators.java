import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Iterators {
    public static void main(String[] args) {
        // Fail-Fast iterators throws ConcurrentModificationException when we try to modify the resource when iterating
        try {
            List<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list1.add(2);
            list1.add(3);
            for (Integer integer : list1) {
                System.out.println(integer);
                if (integer == 3) {
                    list1.add(6);
                }
            }
        }
        catch (ConcurrentModificationException concurrentModificationException){
            System.out.println(concurrentModificationException.toString());
        }

        // Fail-safe iterators return a copy of the collection, so they don't throw exceptions when iterating
        List<Integer> list2 = new CopyOnWriteArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        for (Integer integer : list2) {
            System.out.println(integer);
            if (integer == 3) {
                list2.add(6);
            }
        }

        // Note: We added 6 to the original list not to the copied list, so 6 is not printed
    }
}
