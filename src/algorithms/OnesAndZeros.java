package algorithms;

public class OnesAndZeros {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zero = 0, one = 0;
            for (char c : str.toCharArray())
                if (c == '0') zero++;
                else one++;
            for (int j = m; j >= zero; j--)
                for (int k = n; k >= one; k--)
                    dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strs = { "10", "0001", "111001", "1", "0" };
        System.out.println(new OnesAndZeros().findMaxForm(strs, 5, 3));
    }

}
