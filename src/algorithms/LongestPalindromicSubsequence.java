package algorithms;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++)
                dp[i][j] = cs[i] == cs[j] ? dp[i + 1][j - 1] + 2
                        : Math.max(dp[i][j - 1], dp[i + 1][j]);
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().longestPalindromeSubseq("bbbab"));
    }

}
