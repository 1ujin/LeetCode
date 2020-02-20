package algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Permutations2 {
    
    // backtracking
    public static List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) return result;
        Arrays.sort(nums);
        Deque<Integer> tmp = new ArrayDeque<>();
        boolean[] isUsed = new boolean[len];
        backtrack(nums, len, 0, isUsed, tmp, result);
        return result;
    }
    
    public static void backtrack(int[] nums,
            int len,
            int depth,
            boolean[] isUsed,
            Deque<Integer> tmp,
            List<List<Integer>> result) {
        if (depth == len) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i] && (i == 0 || nums[i] != nums[i - 1] || !isUsed[i - 1])) {
                tmp.addLast(nums[i]);
                isUsed[i] = true;
                backtrack(nums, len, depth + 1, isUsed, tmp, result);
                tmp.removeLast();
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<List<Integer>> result = permuteUnique(new int[] {3, 3, 0, 3});
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
