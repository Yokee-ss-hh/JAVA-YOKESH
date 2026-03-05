package lld;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class LfuNode {
    String key;
    String value;
    LfuNode prev;
    LfuNode next;
    int freq;
    LfuNode(){}
    LfuNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class LfuDLL {
    LfuNode head = new LfuNode();
    LfuNode tail = new LfuNode();

    LfuDLL() {
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void addToFirst(LfuNode node) {
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next.prev = node;
        this.head.next = node;
    }

    public void removeNode(LfuNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public boolean isEmpty() {
        return this.head.next == this.tail;
    }
}

public class LFUCache {
    Map<Integer, LfuDLL> dllMap = new HashMap<>();
    Map<String, LfuNode> cacheMap = new HashMap<>();
    int capacity;
    int minFreq = 1;

    LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public void updateMinFreq(Integer oldFreq) {
        if (oldFreq == minFreq && dllMap.get(oldFreq).isEmpty()) {
            this.minFreq++;
        }
    }

    public String get(String key) {
        if (this.cacheMap.containsKey(key)) {
            LfuNode node = cacheMap.get(key);
            int oldFreq = node.freq;

            this.dllMap.get(Optional.of(oldFreq)).removeNode(node);
            node.freq++;
            this.dllMap.putIfAbsent(Integer.valueOf(node.freq), new LfuDLL()).addToFirst(node);

            updateMinFreq(Integer.valueOf(oldFreq));
            return node.value;
        }
        return null;
    }

    public void put(String key, String value) {
        if (this.capacity <= 0) return;

        if (cacheMap.containsKey(key)) {
            LfuNode existingNode = cacheMap.get(key);
            existingNode.value = value;

            int oldFreq = existingNode.freq;
            this.dllMap.get(Optional.of(oldFreq)).removeNode(existingNode);
            existingNode.freq++;
            this.dllMap.putIfAbsent(Integer.valueOf(existingNode.freq), new LfuDLL()).addToFirst(existingNode);

            updateMinFreq(Integer.valueOf(oldFreq));
        } else {
            if (this.cacheMap.size() == this.capacity) {
                LfuDLL minList = this.dllMap.get(Optional.of(this.minFreq));
                LfuNode toBeRemoved = minList.tail.prev;
                minList.removeNode(toBeRemoved);
                this.cacheMap.remove(toBeRemoved.key);
            }

            LfuNode newNode = new LfuNode(key, value);
            this.cacheMap.put(key, newNode);
            this.minFreq = 1;
            this.dllMap.putIfAbsent(Integer.valueOf(1), new LfuDLL()).addToFirst(newNode);
        }
    }
}