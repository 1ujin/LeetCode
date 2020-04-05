package lcci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShortestSupersequence {

    public int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : small)
            map.put(i, -1);
        int distance = Integer.MAX_VALUE, start = -1, end = -1, count = 0;
        for (int i = 0; i < big.length; i++) {
            if (map.containsKey(big[i])) {
                if (map.get(big[i]) == -1)
                    count++;
                map.put(big[i], i);
            }
            // java 8
//            int newVal = i;
//            map.computeIfPresent(big[i], (k, v) -> newVal);
            // 查找 -1 值较慢
//            if (map.containsValue(-1)) continue;
//            int min = Integer.MAX_VALUE;
//            for (int j : map.values())
//                min = min < j ? min : j;
            // 利用计数法较快
            if (count < small.length) continue;
            int min = Integer.MAX_VALUE, minKey = Integer.MAX_VALUE;
            for (int key : map.keySet())
                if (map.get(key) < min) {
                    min = map.get(key);
                    minKey = key;
                }
            map.put(minKey, -1);
            count--;
            // java 8
//            int min = map.keySet().stream().mapToInt(k -> map.get(k))
//                    .summaryStatistics().getMin();
            if (i - min < distance) {
                distance = i - min;
                start = min;
                end = i;
            }
        }
        if (distance == Integer.MAX_VALUE) return new int[0];
        return new int[] { start, end };
    }

    public static void main(String[] args) {
        int[] big = { 7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7 };
        int[] small = { 1, 5, 9 };
        System.out.println(Arrays
                .toString(new ShortestSupersequence().shortestSeq(big, small)));
    }

}
