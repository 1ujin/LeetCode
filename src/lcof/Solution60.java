package lcof;

import java.util.Arrays;

public class Solution60 {
    
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        double result[] = new double[5 * n + 1];
        for (int i = 1; i < 7; i++)
            dp[1][i] = 1;
        for (int i = 2; i <= n; i++)
            for (int j = i; j <= 6 * i; j++)
                for (int k = 1; k < 7 && j - k >= i - 1; k++)
                    dp[i][j] += dp[i - 1][j - k];
        double deno = Math.pow(6, n);
        for (int i = n; i <= 6 * n; i++)
            result[i - n] = (double) dp[n][i] / deno;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution60().twoSum(2)));
    }

}
