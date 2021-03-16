package algorithms;

import java.util.Arrays;

public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        char[] scs = s.toCharArray(), tcs = t.toCharArray();
        int[][] dp = new int[tcs.length + 1][scs.length + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= tcs.length; i++) {
            for (int j = 1; j < scs.length + 1; j++) {
                if (tcs[i - 1] == scs[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[tcs.length][scs.length];
    }

    public static void main(String[] args) {
        System.out.println(new DistinctSubsequences().numDistinct("babgbag", "bag"));
    }

}
