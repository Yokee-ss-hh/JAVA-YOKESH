package lld;


import java.util.Arrays;
import java.util.Objects;

class CustomNode{
    String key;
    String value;
    CustomNode next;
    CustomNode(){}
    CustomNode(String key,String value){
        this.key=key;
        this.value=value;
        this.next=null;
    }
}
class CustomLinkedList{
    CustomNode head;
    public String insertNode(String key,String value){
        if(this.head == null){
            this.head = new CustomNode(key,value);
        }
        else{
            CustomNode currentNode = this.head;
            CustomNode previousNode = currentNode;
            while(currentNode != null){
                if(currentNode.key.equals(key)){
                    currentNode.value=value;
                    return value;
                }
                previousNode = currentNode;
                currentNode =currentNode.next;
            }
            previousNode.next=new CustomNode(key,value);
        }
        return value;
    }
    public String getNode(String key){
        if(this.head == null){
            return null;
        }
        else{
            CustomNode temp = this.head;
            while (temp != null){
                if(Objects.equals(temp.key, key)){
                    return temp.value;
                }
                temp = temp.next;
            }
        }
        return null;
    }
}
public class CustomHashMap {
    int size;
    CustomLinkedList[] buckets;
    CustomHashMap(int size){
        this.size=size;
        this.buckets = new CustomLinkedList[size];
        for(int i=0;i<size;i++){
            buckets[i]=new CustomLinkedList();
        }
    }
    private Integer calculateHash(String key){
        if(key==null){
            return 0;
        }
        return Math.abs(key.hashCode())%this.size;
    }
    public String get(String key){
        int index = calculateHash(key);
        return buckets[index].getNode(key);
    }
    public String put (String key, String value){
        int index = calculateHash(key);
        return buckets[index].insertNode(key,value);
    }

    public static void main(String[] args) {
        CustomHashMap customHashMap = new CustomHashMap(5);
        customHashMap.put("a","b");
        customHashMap.put("c","d");
        customHashMap.put("e","f");
        System.out.println(customHashMap.get("e"));
        System.out.println(customHashMap.get("a"));
        System.out.println(customHashMap.get("c"));
        System.out.println(customHashMap.get("z"));
        customHashMap.put("a","A");
        System.out.println(customHashMap.get("a"));
    }
}
