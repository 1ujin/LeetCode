package algorithms;

public class InterleavingString {

    // method 1 dynamic programming
    public boolean isInterleave1(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray(), cs3 = s3.toCharArray();
        for (int i = 0; i < len1; i++)
            dp[i + 1][0] = dp[i][0] && cs1[i] == cs3[i];
        for (int i = 0; i < len2; i++)
            dp[0][i + 1] = dp[0][i] && cs2[i] == cs3[i];
        for (int i = 1; i <= len1; i++)
            for (int j = 1; j <= len2; j++)
                dp[i][j] = dp[i - 1][j] && cs1[i - 1] == cs3[i + j - 1]
                        || dp[i][j - 1] && cs2[j - 1] == cs3[i + j - 1];
        return dp[len1][len2];
    }
    
    // method 2 space optimization
    public boolean isInterleave2(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) return false;
        boolean[] dp = new boolean[len2 + 1];
        dp[0] = true;
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray(), cs3 = s3.toCharArray();
        for (int i = 0; i < len2; i++)
            dp[i + 1] = dp[i] && cs2[i] == cs3[i];
        for (int i = 1; i <= len1; i++) {
            dp[0] = dp[0] && cs1[i - 1] == cs3[i - 1];
            for (int j = 1; j <= len2; j++)
                dp[j] = dp[j] && cs1[i - 1] == cs3[i + j - 1]
                        || dp[j - 1] && cs2[j - 1] == cs3[i + j - 1];
        }
        return dp[len2];
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave2("aabcc",
                "dbbca", "aadbbcbcac"));
    }

}
