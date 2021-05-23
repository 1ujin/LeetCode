package algorithms;

public class StrangePrinter {
    
    public int strangePrinter(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (cs[i] == cs[j])
                    dp[i][j] = dp[i][j - 1];
                else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++)
                        min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new StrangePrinter().strangePrinter("aaabbb"));
    }

}
