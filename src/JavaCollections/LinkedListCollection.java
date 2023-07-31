package JavaCollections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.*;

public class LinkedListCollection {
    public static void main(String[] args) {
        // All methods we covered in "ArrayListCollection.java" file can be used with LinkedList class
        // But there are some methods specific to LinkedList class, They are:

        LinkedList<Integer> linkedList = new LinkedList<>();

        // 1) addFirst(element) -> Adds element at the beginning of the linked list
        // 2) addLast(element) -> Adds element at the end of linked list
        linkedList.addFirst(100);
        linkedList.addLast(200);
        linkedList.add(250);
        System.out.println(linkedList);

        // 3) getFirst() -> Returns first element of linked list
        // 4) getLast() -> Returns last element of linked list
        // If linked list is empty -> Throws exception
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        // 5) offer() calls add() internally
        // 6) offerFirst() calls addFirst() internally
        // 7) offerLast() calls addLast() internally
        linkedList.offer(300);
        linkedList.offerFirst(90);
        linkedList.offerLast(400);
        linkedList.offerLast(500);
        linkedList.offerLast(600);
        linkedList.offerLast(700);
        System.out.println(linkedList);

        // 8) peek() -> returns first element , if ll is empty returns null
        // 9) peekFirst() -> returns first element, if ll is empty returns null
        // 10) peekLast() -> returns last element, if ll is empty returns null
        System.out.println(linkedList.peek());
        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());

        // 11) remove() -> removes first element and throws exception if ll is empty
        // 12) removeFirst() -> removes first element and throws exception if ll is empty
        // 13) removeLast() -> removes last element and throws exception if ll is empty
        System.out.println(linkedList.remove());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());

        // 14) poll() -> removes first element and returns it, if ll is empty, returns null
        // 15) pollFirst() -> removes first element and returns it, if ll is empty, returns null
        // 16) pollLast(), -> removes last element and returns it, if ll is empty, returns null
        System.out.println(linkedList.poll());
        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList.pollLast());

        // 17) pop() removes first element and returns it
        // Internally calls removeFirst() and throws exception if ll is empty
        System.out.println(linkedList.pop());

        // 18) push() inserts element from the beginning of the list
        // push() internally class addFirst()
        linkedList.push(1234);
        System.out.println(linkedList);

        linkedList.addLast(1000);
        linkedList.addLast(1200);
        linkedList.addLast(1000);
        linkedList.addLast(1600);
        linkedList.addLast(1000);

        System.out.println(linkedList);

        // 19) removeFirstOccurrence()
        // 20) removeLastOccurrence()
        System.out.println(linkedList.removeFirstOccurrence(1000));
        System.out.println(linkedList);
        System.out.println(linkedList.removeLastOccurrence(1000));
        System.out.println(linkedList);

        // 21) clone() -> makes shallow copy
        LinkedList<Integer> copiedLinkedList = (LinkedList<Integer>) linkedList.clone();
        System.out.println(copiedLinkedList);
    }
}
