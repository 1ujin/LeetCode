package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SplitArrayIntoConsecutiveSubsequences {
    
    // method 1
    public boolean isPossible1(int[] nums) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, new PriorityQueue<>());
            if (!map.containsKey(num - 1))
                map.get(num).offer(1);
            else {
                map.get(num).offer(map.get(num - 1).poll() + 1);
                if (map.get(num - 1).isEmpty())
                    map.remove(num - 1);
            }
        }
        for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet())
            if (entry.getValue().peek() < 3) return false;
        return true;
    }
    
    // method 2
    public boolean isPossible2(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (int num : nums)
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        for (int num : nums) {
            int count = map1.get(num);
            if (count == 0) continue;
            int prevCount = map2.getOrDefault(num - 1, 0);
            if (prevCount > 0) {
                map1.put(num, count - 1);
                map2.put(num - 1, prevCount - 1);
                map2.put(num, map2.getOrDefault(num, 0) + 1);
            } else {
                int nextCount = map1.getOrDefault(num + 1, 0);
                int nextNextCount = map1.getOrDefault(num + 2, 0);
                if (nextCount > 0 && nextNextCount > 0) {
                    map1.put(num, count - 1);
                    map1.put(num + 1, nextCount - 1);
                    map1.put(num + 2, nextNextCount - 1);
                    map2.put(num + 2, map2.getOrDefault(num + 2, 0) + 1);
                } else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3, 4, 5 };
        System.out.println(new SplitArrayIntoConsecutiveSubsequences().isPossible2(nums));
    }

}
