package algorithms;

import java.util.LinkedList;
import java.util.List;

interface MyHashSet {
    
    void add(int key);
    
    void remove(int key);
    
    boolean contains(int key);
}

// method 1 fastest
class MyHashSet1 implements MyHashSet {
    private boolean[] set;

    /** Initialize your data structure here. */
    public MyHashSet1() {
        set = new boolean[1000001];
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return set[key];
    }
}

// method 2
class MyHashSet2 implements MyHashSet {
    private static final int BASE = 769;
    @SuppressWarnings("rawtypes")
    private List[] set;

    /** Initialize your data structure here. */
    public MyHashSet2() {
        set = new List[BASE];
        for (int i = 0; i < BASE; i++)
            set[i] = new LinkedList<>();
    }
    
    @SuppressWarnings("unchecked")
    public void add(int key) {
        int hash = key % BASE;
        for (Object element : set[hash])
            if ((Integer) element == key)
                return;
        set[hash].add(key);
    }
    
    public void remove(int key) {
        int hash = key % BASE;
        if (set[hash].contains(key))
            set[hash].remove(Integer.valueOf(key));
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key % BASE;
        for (Object element : set[hash])
            if ((Integer) element == key)
                return true;
        return false;
    }
}

public class DesignHashset {

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet2();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));
        myHashSet.remove(2);
        System.out.println(myHashSet.contains(2));
    }

}
