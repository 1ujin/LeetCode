package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.compute(num, (key, v) -> v == null ? 1 : ++v);
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            queue.offer(new int[] { entry.getKey(), entry.getValue() });
        int[] arr = new int[k];
        for (int i = 0; i < k; i++)
            arr[i] = queue.poll()[0];
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(nums, 2)));
    }

}
