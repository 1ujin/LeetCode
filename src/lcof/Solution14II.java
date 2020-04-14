package lcof;

public class Solution14II {
    
    // method 1 dynamic programming
    public int cuttingRope1(int n) {
        long[] dp = new long[n > 5 ? n + 1 : 7];
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        for (int i = 7; i <= n; i++)
            dp[i] = dp[i - 3] * 3 % 1000000007;
        return (int) dp[n];
    }
    
    // method 2 greedy algorithm
    public int cuttingRope2(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        long product = 1;
        while (n > 4) {
            product *= 3;
            product %= 1000000007;
            n -= 3;
        }
        return (int) (product * n % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new Solution14II().cuttingRope2(120));
    }

}
