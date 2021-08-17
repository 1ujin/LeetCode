package algorithms;

public class StudentAttendanceRecord2 {

    public int checkRecord(int n) {
        int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] += dp[i - 1][j][k];
                    dp[i][j][0] %= 1000000007;
                }
            }
            for (int k = 0; k < 3; k++) {
                dp[i][1][0] += dp[i - 1][0][k];
                dp[i][1][0] %= 1000000007;
            }
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    dp[i][j][k] += dp[i - 1][j][k - 1];
                    dp[i][j][k] %= 1000000007;
                }
            }
        }
        int count = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                count += dp[n][j][k];
                count %= 1000000007;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new StudentAttendanceRecord2().checkRecord(10101));
    }

}
