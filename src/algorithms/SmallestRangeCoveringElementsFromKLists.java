package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class SmallestRangeCoveringElementsFromKLists {
    
    // method 1 heap
    public int[] smallestRange1(List<List<Integer>> nums) {
        int k = nums.size(), left = 0, right = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] next = new int[k];
        Queue<Integer> queue = new PriorityQueue<>(
                (a, b) -> nums.get(a).get(next[a]) - nums.get(b).get(next[b]));
        for (int i = 0; i < k; i++) {
            queue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            int minIdx = queue.poll();
            int current = max - nums.get(minIdx).get(next[minIdx]);
            if (current < min) {
                min = current;
                left = nums.get(minIdx).get(next[minIdx]);
                right = max;
            }
            next[minIdx]++;
            if (next[minIdx] == nums.get(minIdx).size())
                break;
            queue.offer(minIdx);
            max = Math.max(max, nums.get(minIdx).get(next[minIdx]));
        }
        return new int[] { left, right };
    }
    
    // method 2 fastest
    public int[] smallestRange2(List<List<Integer>> nums) {
        int len = 0;
        for (List<Integer> list : nums)
            len += list.size();
        int[][] arr = new int[len][2];
        int i = 0, j = 0;
        for (List<Integer> list : nums) {
            for (Integer integer : list) {
                arr[i][0] = integer;
                arr[i][1] = j;
                i++;
            }
            j++;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int[] range = new int[2], count = new int[nums.size()];
        int k = 0;
        for (i = j = 0; i < len; i++) {
            if (count[arr[i][1]]++ == 0)
                k++;
            if (k == nums.size()) {
                while (count[arr[j][1]] > 1)
                    count[arr[j++][1]]--;
                int r1 = range[1] - range[0], r2 = arr[i][0] - arr[j][0];
                if (range[0] == 0 && range[1] == 0 || r1 > r2 || r1 == r2 && arr[j][0] < range[0]) {
                    range[0] = arr[j][0];
                    range[1] = arr[i][0];
                }
            }
        }
        return range;
    }

    public static void main(String[] args) {
        int[][] arrs = { { 4, 10, 15, 24, 26 }, { 0, 9, 12, 20 }, { 5, 18, 22, 30 } };
        List<List<Integer>> nums = Arrays.stream(arrs).map(arr -> {
            List<Integer> list = new ArrayList<>();
            for (int i : arr)
                list.add(i);
            return list;
        }).collect(Collectors.toList());
        System.out.println(Arrays.toString(new SmallestRangeCoveringElementsFromKLists().smallestRange2(nums)));
    }

}
