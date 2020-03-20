package lcci;

public class BooleanEvaluation {
    
    private char[] vals;
    private char[] operators;
    private int[][][] dp;
    
    public int countEval(String s, int result) {
        int len = s.length();
        vals = new char[len / 2 + 1];
        operators = new char[len / 2];
        dp = new int[len / 2 + 1][len / 2 + 1][2];
        for (int i = 0; i < vals.length; i++)
            vals[i] = s.charAt(i * 2);
        for (int i = 0; i < operators.length; i++)
            operators[i] = s.charAt(i * 2 + 1);
        fillDp();
        return dp[0][len / 2][result];
    }
    
    // bottom-up
    private void fillDp() {
        for (int i = 0; i < dp.length; i++)
            for (int k = 0; k < 2; k++)
                dp[i][i][k] = vals[i] == k + '0' ? 1 : 0;
        for (int n = 1; n < dp.length; n++) {
            for (int i = 0; i < dp.length - n; i++) {
                int j = i + n;
                for (int mid = i; mid < j; mid++) {
                    if (operators[mid] == '&') {
                        dp[i][j][0] += dp[i][mid][0] * dp[mid + 1][j][0] + dp[i][mid][0] * dp[mid + 1][j][1] + dp[i][mid][1] * dp[mid + 1][j][0];
                        dp[i][j][1] += dp[i][mid][1] * dp[mid + 1][j][1];
                    } else if (operators[mid] == '^') {
                        dp[i][j][0] += dp[i][mid][0] * dp[mid + 1][j][0] + dp[i][mid][1] * dp[mid + 1][j][1];
                        dp[i][j][1] += dp[i][mid][0] * dp[mid + 1][j][1] + dp[i][mid][1] * dp[mid + 1][j][0];
                    } else {
                        dp[i][j][0] += dp[i][mid][0] * dp[mid + 1][j][0];
                        dp[i][j][1] += dp[i][mid][1] * dp[mid + 1][j][1] + dp[i][mid][0] * dp[mid + 1][j][1] + dp[i][mid][1] * dp[mid + 1][j][0];
                    }
                }
            }
        }
    }
    
    // top-down time limit exceeded
    @SuppressWarnings("unused")
    private int dp(int i, int j, int k) {
        if (i == j) return vals[i] == k + '0' ? 1 : 0;
        int count = 0;
        for (int mid = i; mid < j; mid++) {
            if (operators[mid] == '&') {
                if (k == 1) count += dp(i, mid, 1) * dp(mid + 1, j, 1);
                else count += dp(i, mid, 0) * dp(mid + 1, j, 0) + dp(i, mid, 0) * dp(mid + 1, j, 1) + dp(i, mid, 1) * dp(mid + 1, j, 0);
            } else if (operators[mid] == '^') {
                if (k == 0) count += dp(i, mid, 0) * dp(mid + 1, j, 0) + dp(i, mid, 1) * dp(mid + 1, j, 1);
                else count += dp(i, mid, 0) * dp(mid + 1, j, 1) + dp(i, mid, 1) * dp(mid + 1, j, 0);
            } else {
                if (k == 0) count += dp(i, mid, 0) * dp(mid + 1, j, 0);
                else count += dp(i, mid, 1) * dp(mid + 1, j, 1) + dp(i, mid, 0) * dp(mid + 1, j, 1) + dp(i, mid, 1) * dp(mid + 1, j, 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int result = new BooleanEvaluation().countEval("0^1^1|0^1^0|0&1^0|1^1&1|1", 0);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
