package lld;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Node {
    String key;
    String value;
    Node prev;
    Node next;
    Node(){}
    Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class DLL{
    Node head = new Node();
    Node tail = new Node();
    @Override
    public String toString(){
        Node dummy = this.head.next;
        while(dummy!= this.tail){
            System.out.println(dummy.key+"->"+dummy.value);
            dummy=dummy.next;
        }
        return null;
    }
    DLL(){
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    public void addToFirst(Node node){
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev=node.prev;
    }
}
public class LRUCache {
    Map<String,Node> cacheMap = new HashMap<>();
    DLL dll = new DLL();
    int size=0;
    public LRUCache(int size){
        this.size=size;
    }

    public String get(String key){
        if(cacheMap.containsKey(key)){
            Node getNode = cacheMap.get(key);
            this.dll.removeNode(getNode);
            this.dll.addToFirst(getNode);
            return getNode.value;
        }
        else{
            return null;
        }
    }
    public void put(String key, String value){
        if(cacheMap.containsKey(key)){
            Node existingNode = cacheMap.get(key);
            existingNode.value=value;
            dll.removeNode(existingNode);
            dll.addToFirst(existingNode);
        }
        else{
            if(this.size == this.cacheMap.size()){
                Node toBeRemoved = this.dll.tail.prev;
                this.dll.removeNode(toBeRemoved);
                cacheMap.remove(toBeRemoved.key);
            }
            Node newNode = new Node(key,value);
            this.dll.addToFirst(newNode);
            cacheMap.put(key,newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put("name","yokesh");
        lruCache.put("city","bangalore");
        lruCache.get("name");
        lruCache.dll.toString();
        System.out.println(lruCache.cacheMap);
        lruCache.put("hobby","games");
        lruCache.dll.toString();
        System.out.println(lruCache.cacheMap);

        // TC : O(1)
        // SC : O(n) -> HashMap & DLL size
    }
}
