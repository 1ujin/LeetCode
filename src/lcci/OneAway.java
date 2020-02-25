package lcci;

import java.util.Arrays;

public class OneAway {
    
    // method 1 two printer
    public boolean oneEditAway1(String first, String second) {
        if (first.equals(second)) return true;
        int len1 = first.length(), len2 = second.length();
        if (len1 - len2 > 1 || len2 - len1 > 1) return false;
        int i = 0, j = 0;
        // 从左开始统计相同的字符数
        while (i < len1 && i < len2)
            if (first.charAt(i) == second.charAt(i)) i++;
            else break;
        // 从右开始统计相同的字符数
        while (len1 >= j + 1 && len2 >= j + 1)
            if (first.charAt(len1 - 1 - j) == second.charAt(len2 - 1 - j)) j++;
            else break;
        return (i + j) * 2 >= len1 + len2 - 2;
    }
    
    // method 2 dynamic programming
    public boolean oneEditAway2(String first, String second) {
        int len1 = first.length(), len2 = second.length();
        int[][] dp = new int[2][len2 + 1];
        for (int i = 0; i <= len2; i++) dp[0][i] = i;
        for (int i = 1; i <= len1; i++) {
            dp[1][0] = i;
            for (int j = 1; j <= len2; j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1))
                    dp[1][j] = dp[0][j - 1];
                else
                    dp[1][j] = Math.min(Math.min(dp[0][j - 1], dp[0][j]), dp[1][j - 1]) + 1;
            }
            dp[0] = Arrays.copyOf(dp[1], len2 + 1);
        }
        return dp[1][len2] <= 1;
    }

    public static void main(String[] args) {
        OneAway solution = new OneAway();
        long startTime = System.nanoTime();
        boolean result = solution.oneEditAway1("teacher", "bleacher");
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
