package algorithms;

import java.util.HashMap;
import java.util.Map;

class MapSum {
    private class Trie {
        int val = 0;
        Trie[] next = new Trie[26];
    }

    private Trie root;
    private Map<String, Integer> map;

    public MapSum() {
        root = new Trie();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        map.put(key, val);
        Trie trie = root;
        for (char c : key.toCharArray()) {
            int index = c - 'a';
            if (trie.next[index] == null)
                trie.next[index] = new Trie();
            trie = trie.next[index];
            trie.val += diff;
        }
    }

    public int sum(String prefix) {
        Trie trie = root;
        for (char c : prefix.toCharArray()) {
            trie = trie.next[c - 'a'];
            if (trie == null)
                return 0;
        }
        return trie.val;
    }
}

public class MapSumPairs {

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        mapSum.insert("apple", 2);
        System.out.println(mapSum.sum("ap"));
    }

}
