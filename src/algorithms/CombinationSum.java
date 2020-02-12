package algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    
    private static List<List<Integer>> result = null;
    private static int[] candidates;
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        CombinationSum.candidates = candidates;
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
            // 元素可复用，起始序号不变
            if (!backTrack(i, current, newTarget)) {
                current.removeLast();
                break;
            }
            current.removeLast();
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        combinationSum(new int[] {2, 3, 6, 7}, 7);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
