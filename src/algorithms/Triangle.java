package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len + 1];
        for (int i = len - 1; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
        return dp[0];
    }

    public static void main(String[] args) {
        int[][] nums = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
        List<List<Integer>> triangle = Arrays.stream(nums).map(arr -> {
            List<Integer> list = new ArrayList<>();
            for (int i : arr)
                list.add(i);
            return list;
        }).collect(Collectors.toList());
        System.out.println(new Triangle().minimumTotal(triangle));
    }

}
