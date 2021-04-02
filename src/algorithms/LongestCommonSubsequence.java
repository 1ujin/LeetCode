package algorithms;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] cs1 = text1.toCharArray(), cs2 = text2.toCharArray();
        int len1 = cs1.length, len2 = cs2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++)
            for (int j = 1; j <= len2; j++)
                dp[i][j] = cs1[i - 1] == cs2[j - 1] ? dp[i - 1][j - 1] + 1
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));
    }

}
