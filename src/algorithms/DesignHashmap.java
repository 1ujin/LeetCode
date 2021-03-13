package algorithms;

import java.util.LinkedList;
import java.util.List;

interface MyHashMap {
    /** value will always be non-negative. */
    public void put(int key, int value);
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key);
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key);
}

// method 1
class MyHashMap1 implements MyHashMap {
    int[] map;

    /** Initialize your data structure here. */
    public MyHashMap1() {
        map = new int[1000001];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value + 1;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key] - 1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = 0;
    }
}

// method 2
class MyHashMap2 implements MyHashMap {
    private static final int BASE = 769;
    @SuppressWarnings("rawtypes")
    private List[] map;

    /** Initialize your data structure here. */
    public MyHashMap2() {
        map = new List[BASE];
        for (int i = 0; i < BASE; i++)
            map[i] = new LinkedList<>();
    }
    
    /** value will always be non-negative. */
    @SuppressWarnings("unchecked")
    public void put(int key, int value) {
        int hash = key % BASE;
        for (int i = 0; i < map[hash].size(); i++) {
            int[] element = (int[]) map[hash].get(i);
            if (element[0] == key) {
                element[1] = value;
                return;
            }
        }
        map[hash].add(new int[] { key, value });
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % BASE;
        for (int i = 0; i < map[hash].size(); i++) {
            int[] element = (int[]) map[hash].get(i);
            if (element[0] == key)
                return element[1];
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % BASE;
        for (int i = 0; i < map[hash].size(); i++) {
            if (((int[]) map[hash].get(i))[0] == key) {
                map[hash].remove(i);
                return;
            }
        }
    }
}

// method 3 fastest
class MyHashMap3 implements MyHashMap {
    private static final int BASE = 1000;
    private Node[] tables;
    
    private class Node {
        int key, value;
        Node prev, next;
        
        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap3() {
        tables = new Node[BASE];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key % BASE;
        Node node = tables[hash];
        while (node != null) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        tables[hash] = new Node(key, value, null, tables[hash]);
        if (tables[hash].next != null)
            tables[hash].next.prev = tables[hash];
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node node = tables[key % BASE];
        while (node != null) {
            if (node.key == key)
                return node.value;
            else node = node.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % BASE;
        Node node = tables[hash];
        if (node == null)
            return;
        if (node.key == key) {
            tables[hash] = node.next;
            return;
        }
        while (node != null) {
            if (node.key == key) {
                if (node.prev != null)
                    node.prev.next = node.next;
                if (node.next != null)
                    node.next.prev = node.prev;
                return;
            } else node = node.next;
        }
    }
}

public class DesignHashmap {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap3();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }

}
