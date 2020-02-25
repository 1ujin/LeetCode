package algorithms;

import java.util.Arrays;

public class EditDistance {
    
    // method 1 dynamic programming bottom-up
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0 || len2 == 0) return len1 + len2;
        int[][] dp = new int[2][len2 + 1];
        for (int i = 0; i <= len2; i++) dp[0][i] = i;
        for (int i = 1; i <= len1; i++) {
            dp[1][0] = i;
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[1][j] = dp[0][j - 1];
                else
                    dp[1][j] = Math.min(Math.min(dp[0][j - 1], dp[0][j]), dp[1][j - 1]) + 1;
            }
            dp[0] = Arrays.copyOf(dp[1], len2 + 1);
        }
        return dp[1][len2];
    }

    public static void main(String[] args) {
        EditDistance solution = new EditDistance();
        long startTime = System.nanoTime();
        int result = solution.minDistance("horse", "ros");
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
