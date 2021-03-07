package algorithms;

import java.util.Arrays;

public class PalindromePartitioning2 {
    
    public int minCut(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        boolean[][] isPalindrome = new boolean[len][len];
        for (boolean[] row : isPalindrome)
            Arrays.fill(row, true);
        for (int begin = len - 1; begin >= 0; begin--)
            for (int end = begin + 1; end < len; end++)
                isPalindrome[begin][end] = cs[begin] == cs[end] && isPalindrome[begin + 1][end - 1];
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int end = 0; end < len; end++) {
            if (isPalindrome[0][end]) {
                dp[end] = 0;
                continue;
            }
            for (int begin = 0; begin < end; begin++)
                if (isPalindrome[begin + 1][end])
                    dp[end] = Math.min(dp[end], dp[begin] + 1);
        }
        return  dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning2().minCut("aab"));
    }

}
