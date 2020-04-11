package algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);
        // 覆盖删除最旧元素方法
        // map = new LinkedHashMap<>(capacity, 0.75f, true) {
        //     @Override
        //     protected boolean removeEldestEntry(Map.Entry eldest) {
        //         if (this.size() > capacity) return true;
        //         return false;
        //     };
        // };
    }
    
    public int get(int key) {
        if (map.containsKey(key)) map.put(key, map.remove(key));
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        } else {
            if (map.size() == capacity)
                map.remove(map.entrySet().iterator().next().getKey());
            map.put(key, value);
        }
    }
    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));   // 返回  1
        cache.put(3, 3);                    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));   // 返回 -1 (未找到)
        cache.put(4, 4);                    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));   // 返回 -1 (未找到)
        System.out.println(cache.get(3));   // 返回  3
        System.out.println(cache.get(4));   // 返回  4
    }

}
