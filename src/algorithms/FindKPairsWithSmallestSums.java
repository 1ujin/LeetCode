package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Queue<int[]> queue = new PriorityQueue<>(k, (a, b) -> nums1[a[0]]
                + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        for (int i = 0; i < Math.min(nums1.length, k); i++)
            queue.offer(new int[] { i, 0 });
        List<List<Integer>> list = new ArrayList<>();
        while (k-- > 0 && !queue.isEmpty()) {
            int[] pair = queue.poll();
            list.add(Arrays.asList(nums1[pair[0]], nums2[pair[1]]));
            if (pair[1] + 1 < nums2.length)
                queue.offer(new int[] { pair[0], pair[1] + 1 });
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };
        System.out.println(new FindKPairsWithSmallestSums()
                .kSmallestPairs(nums1, nums2, 3));
    }

}
