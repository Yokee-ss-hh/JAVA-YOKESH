package JavaCollections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// PriorityQueue implemented as Balanced Binary Heap
// Queue interface extends from Collection interface
// Queue interface provides some methods other than from Collection interface
// 1) offer(): Adds element at the head of queue similar to add() from Collections interface
// 2) remove(): Returns by removing head of queue, throws exception if queue is empty
// 3) poll(): Returns by removing head of queue, returns null if queue is empty
// 4) element(): Retrieves head of queue, throws exception if queue is empty
// 5) peek(): Retrieves head of queue, returns null if queue is empty

class IncreasingOrderComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b) {
        if (a < b) {
            return -1;
        } else if (a == b) {
            return 0;
        } else {
            return 1;
        }
    }
}
class DecreasingOrderComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b) {
        if (a < b) {
            return 1;
        } else if (a == b) {
            return 0;
        } else {
            return -1;
        }
    }
}

public class PriorityQueueCollection {
    public static void main(String[] args) {
        Comparator<Integer> increasingOrderComparator = (a,b) ->{
          if(a < b){
              return -1;
          }
          else if(a == b){
              return 0;
          }
          else{
              return -1;
          }
        };
        Comparator<Integer> decreasingOrderComparator = (a,b) ->{
            if(a < b){
                return 1;
            }
            else if(a == b){
                return 0;
            }
            else{
                return -1;
            }
        };

        // We can use above lambda expression comparators (or) we can create a class to override the
        // comparator() method and use that class object.

        Queue<Integer> increasingQueue = new PriorityQueue<>(new IncreasingOrderComparator());
        Queue<Integer> decreasingQueue = new PriorityQueue<>(new DecreasingOrderComparator());
        // Queue<Integer> increasingQueue = new PriorityQueue<>(increasingOrderComparator);
        // Queue<Integer> decreasingQueue = new PriorityQueue<>(decreasingOrderComparator);

        // PriorityQueue does not guarantee the ordering when elements are iterated and printed
        // using for loop / while loop
        // If we use poll() / remove() then java gives guarantee that lowest/ highest elements
        // are retrieved.

        increasingQueue.add(10);
        increasingQueue.add(8);
        increasingQueue.add(18);
        increasingQueue.add(1);
        // Similarly we can use offer()

        decreasingQueue.add(10);
        decreasingQueue.add(8);
        decreasingQueue.add(18);
        decreasingQueue.add(1);
        // Similarly we can use offer()

        System.out.println(increasingQueue.element());
        System.out.println(increasingQueue.peek());

        System.out.println("Elements will be removed from smallest to largest");
        System.out.println(increasingQueue.remove());
        System.out.println(increasingQueue.remove());
        System.out.println(increasingQueue.remove());
        System.out.println(increasingQueue.remove());
        // Similarly we can use poll()

        System.out.println(decreasingQueue.element());
        System.out.println(decreasingQueue.peek());

        System.out.println("Elements will be removed from largest to smallest");
        System.out.println(decreasingQueue.remove());
        System.out.println(decreasingQueue.remove());
        System.out.println(decreasingQueue.remove());
        System.out.println(decreasingQueue.remove());
        // Similarly we can use poll()
    }
}
