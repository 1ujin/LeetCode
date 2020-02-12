package algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    
    private static List<List<Integer>> result = null;
    private static int[] candidates;
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        CombinationSum2.candidates = candidates;
        // LinkedList 速度最快
        result = new LinkedList<>();
        backTrack(0, new LinkedList<Integer>(), target);
        return result;
    }
    
    public static boolean backTrack(int start, LinkedList<Integer> current, int target) {
        if (target < 0) return false;
        if (target == 0) {
            result.add(new LinkedList<>(current));
            return true;
        }
        for (int i = start; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            current.add(candidates[i]);
            if (!backTrack(i + 1, current, newTarget)) {
                current.removeLast();
                break;
            }
            current.removeLast();
            // 同一级路径的循环中跳过重复的元素
            for (; i < candidates.length - 1 && candidates[i] == candidates[i + 1]; i++);
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
