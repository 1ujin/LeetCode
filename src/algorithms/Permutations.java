package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    
    // method 1
    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        result.add(new ArrayList<>());
        result.get(0).add(nums[0]);
        List<List<Integer>> tmp = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            for (List<Integer> list : result) {
                for (int j = list.size(); j >= 0; j--) {
                    List<Integer> tmpElem = new ArrayList<>();
                    tmpElem.addAll(list);
                    tmpElem.add(j, nums[i]);
                    tmp.add(tmpElem);
                }
            }
            result = tmp;
            tmp = new ArrayList<>();
        }
        return result;
    }
    
    // method 2 backtracking
    public static List<List<Integer>> permute2(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) return result;
        boolean[] isUsed = new boolean[len];
        List<Integer> path = new ArrayList<>();
        backtrack(nums, len, 0, path, isUsed, result);
        return result;
    }
    
    public static void backtrack(int[] nums,
            int len,
            int depth,
            List<Integer> path,
            boolean[] isUsed,
            List<List<Integer>> result) {
        if (depth == len) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!isUsed[i]) {
                path.add(nums[i]);
                isUsed[i] = true;
                backtrack(nums, len, depth + 1, path, isUsed, result);
                path.remove(depth);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<List<Integer>> result = permute2(new int[] {1, 2, 3});
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
