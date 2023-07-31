package LinkedLists;

public class SinglyLinkedList {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int x) {
            data = x;
            next = null;
        }
    }
    public void insertFirst(int key){
        Node newNode = new Node(key);
        if(head == null) {
            head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }
    public void insertLast(int key){
        Node newNode = new Node(key);
        Node current = head;
        if (head == null){
            head = newNode;
        }
        else{
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
       }
    }

    public void insertAtIndex(int key, int pos) throws Exception {
        Node newNode = new Node(key);
        if (head == null){
            head = newNode;
        }
        else if(pos < 0){
            throw new Exception("Position pos should be greater than or equal to zero!!");
        }
        else{
            Node current = head;
            if (pos==0){
                newNode.next = current;
                head = newNode;
            }
            else {
                while (pos - 1 != 0 && current.next != null) {
                    current = current.next;
                    pos -= 1;
                }
                Node after = current.next;
                current.next = newNode;
                newNode.next = after;
            }
        }
    }
    public int search(int key){
        Node current = head;
        int index = 0;
        while (current != null){
            if (current.data == key){
                return index;
            }
            else{
                index += 1;
                current = current.next;
            }
        }
        return -1;
    }
    public void printList(){
        Node current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    public void deleteFirst() throws Exception{
        if (head == null){
            throw new Exception("Cannot delete from empty linked list");
        }
        else {
            head = head.next;
        }
    }

    public void deleteLast() throws Exception{
        if (head == null){
            throw new Exception("Cannot delete from empty linked list");
        }
        else{
            Node current = head;
            Node previous = null;
            while(current.next != null){
                previous = current;
                current = current.next;
            }
            if(previous != null){
                previous.next = null;
            }
            else{
                head = null;
            }
        }
    }

    public void delete(int key) throws Exception{

    }

    public void deleteAtPos(int key) throws Exception{

    }


    public static void main(String[] args){
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertFirst(1);
        sll.insertFirst(2);
        try {
            sll.printList();
            sll.deleteFirst();
            sll.printList();
            sll.deleteLast();
            sll.printList();
            sll.deleteFirst();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
