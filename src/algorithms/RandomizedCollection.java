package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RandomizedCollection {
    
    List<Integer> list;
    Map<Integer, Set<Integer>> map;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /**
     * Inserts a value to the collection. Returns true if the collection did not
     * already contain the specified element.
     */
    public boolean insert(int val) {
        list.add(val);
        return map.compute(val, (k, v) -> {
            if (v == null)
                v = new HashSet<>();
            v.add(list.size() - 1);
            return v;
        }).size() == 1;
    }
    
    /**
     * Removes a value from the collection. Returns true if the collection
     * contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int last = list.size() - 1, lastVal = list.get(last);
        int index = map.get(val).iterator().next();
        list.set(index, lastVal);
        map.get(val).remove(index);
        map.get(lastVal).remove(last);
        if (index < last)
            map.get(lastVal).add(index);
        if (map.get(val).size() == 0)
            map.remove(val);
        list.remove(last);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }

    public static void main(String[] args) {
        // 初始化一个空的集合。
        RandomizedCollection collection = new RandomizedCollection();
        // 向集合中插入 1 。返回 true 表示集合不包含 1 。
        System.out.println(collection.insert(1));
        // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
        System.out.println(collection.insert(1));
        // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
        System.out.println(collection.insert(2));
        // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
        System.out.println(collection.getRandom());
        // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
        System.out.println(collection.remove(1));
        // getRandom 应有相同概率返回 1 和 2 。
        System.out.println(collection.getRandom());
    }

}
