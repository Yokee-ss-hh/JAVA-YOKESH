package JavaCollections;

import java.util.*;

public class ArrayDeQueCollection {
    public static void main(String[] args) {
        Deque<Integer> d = new ArrayDeque<>();
        d.addFirst(10);
        d.add(20);
        d.addLast(30);
        d.addFirst(8);
        d.offer(40);
        d.offerLast(50);
        d.offerFirst(5);
        System.out.println(d);

        System.out.println("*****************peek************");
        System.out.println(d.peek());
        System.out.println(d.peekFirst());
        System.out.println(d.peekLast());
        System.out.println(d.element());
        System.out.println(d);

        System.out.println("***********remove and poll**************");
        System.out.println(d.remove());
        System.out.println(d.removeFirst());
        System.out.println(d.removeLast());
        System.out.println(d.poll());
        System.out.println(d.pollFirst());
        System.out.println(d.pollLast());
        System.out.println(d);

        System.out.println("**********getFirst and getLast**********");
        System.out.println(d.getFirst());
        System.out.println(d.getLast());
        System.out.println(d);

        System.out.println("****removeFirstOccurrence and removeLastOccurrence******");
        Deque<Integer> d1 = new ArrayDeque<>(List.of(1,2,3,4,1,2,3,4,1,3,4));
        System.out.println(d1.removeFirstOccurrence(1));
        System.out.println(d1);
        System.out.println(d1.removeLastOccurrence(4));
        System.out.println(d1);

        System.out.println("***************descendingIterator***********");
        Iterator<Integer> descend = d1.descendingIterator();
        while(descend.hasNext()){
            System.out.println(descend.next());
        }
    }
}
