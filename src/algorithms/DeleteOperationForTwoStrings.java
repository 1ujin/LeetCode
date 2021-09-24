package algorithms;

public class DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {
        char[] cs1 = word1.toCharArray(), cs2 = word2.toCharArray();
        int len1 = cs1.length, len2 = cs2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (cs1[i - 1] == cs2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return len1 + len2 - dp[len1][len2] * 2;
    }

    public static void main(String[] args) {
        System.out.println(new DeleteOperationForTwoStrings().minDistance("sea", "eat"));
    }

}
