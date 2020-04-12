package algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

// method 1 slowest
class LFUCache1 implements LFUCache {
    private int capacity;
    private Map<Integer, Integer> cacheMap, freqMap;
    
    public LFUCache1(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity);
        freqMap = new LinkedHashMap<>(capacity);
    }
    
    public int get(int key) {
        if (cacheMap.containsKey(key))
            freqMap.put(key, freqMap.remove(key) + 1);
        return cacheMap.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cacheMap.containsKey(key)) {
            cacheMap.put(key, value);
            freqMap.put(key, freqMap.remove(key) + 1);
        } else {
            if (cacheMap.size() == capacity) {
                Iterator<Integer> iterator = freqMap.keySet().iterator();
                Object minFreqKey = iterator.next();
                while (iterator.hasNext()) {
                    Object freqKey = iterator.next();
                    if (freqMap.get(minFreqKey) > freqMap.get(freqKey))
                        minFreqKey = freqKey;
                }
                cacheMap.remove(minFreqKey);
                freqMap.remove(minFreqKey);
            }
            cacheMap.put(key, value);
            freqMap.put(key, 1);
        }
    }
}

// method 2 fastest
class LFUCache2 implements LFUCache {
    
    private class Node {
        int key, value, freq = 1;
        Node prev, next;
        DoublyLinkedList dll;
        
        public Node() {}

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private class DoublyLinkedList {
        int freq;
        Node head, tail;
        DoublyLinkedList prev, next;
        
        public DoublyLinkedList(int freq) {
            this.freq = freq;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
        
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        
        public void add(Node node) {
            node.dll = this;
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
    }
    
    private int capacity;
    private Map<Integer, Node> map;
    private DoublyLinkedList ascDll, descDll;
    
    public LFUCache2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        ascDll = new DoublyLinkedList(0);
        descDll = new DoublyLinkedList(0);
        ascDll.prev = descDll;
        descDll.next = ascDll;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return - 1;
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0)
            return;
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            updateFreq(node);
        } else {
            if (map.size() == capacity) {
                map.remove(ascDll.prev.tail.prev.key);
                ascDll.remove(ascDll.prev.tail.prev);
                if (ascDll.prev.head.next == ascDll.prev.tail)
                    remove(ascDll.prev);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            if (ascDll.prev.freq != 1) {
                DoublyLinkedList newDll = new DoublyLinkedList(1);
                concat(ascDll.prev, newDll);
                newDll.add(newNode);
            } else ascDll.prev.add(newNode);
        }
    }

    private void concat(DoublyLinkedList preDll, DoublyLinkedList newDll) {
        newDll.next = preDll.next;
        newDll.next.prev = newDll;
        newDll.prev = preDll;
        preDll.next = newDll;
    }

    private void remove(DoublyLinkedList dll) {
        dll.prev.next = dll.next;
        dll.next.prev = dll.prev;
    }

    private void updateFreq(Node node) {
        DoublyLinkedList dll = node.dll;
        DoublyLinkedList preDll = dll.prev;
        dll.remove(node);
        if (dll.head.next == dll.tail)
            remove(dll);
        node.freq++;
        if (preDll.freq != node.freq) {
            DoublyLinkedList newDll = new DoublyLinkedList(node.freq);
            concat(preDll, newDll);
            newDll.add(node);
        } else preDll.add(node);
    }
    
}

interface LFUCache {
    
    int get(int key);
    
    void put(int key, int value);
    
    // since 1.8
    static void main(String[] args) {
        LFUCache cache = new LFUCache2(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));   // 返回 1
        cache.put(3, 3);                    // 去除 key 2
        System.out.println(cache.get(2));   // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));   // 返回 3
        cache.put(4, 4);                    // 去除 key 1
        System.out.println(cache.get(1));   // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));   // 返回 3
        System.out.println(cache.get(4));   // 返回 4
    }

}
