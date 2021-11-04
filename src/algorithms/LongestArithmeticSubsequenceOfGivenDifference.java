package algorithms;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {

    public int longestSubsequence(int[] arr, int difference) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num - difference, 0) + 1);
            max = Math.max(max, map.get(num));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, 8, 5, 3, 4, 2, 1 };
        System.out.println(new LongestArithmeticSubsequenceOfGivenDifference()
                .longestSubsequence(arr, -2));
    }

}
