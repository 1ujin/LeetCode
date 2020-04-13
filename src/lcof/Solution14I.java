package lcof;

public class Solution14I {
    
    // method 1 dynamic programming
    public int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++)
            for (int j = 0; j < i; j++)
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
        return dp[n];
    }
    
    // method 2 fastest
    public int cuttingRope2(int n) {
        if (n <= 3)
            return n - 1;
        if (n % 3 == 0)
            return (int) Math.pow(3, n / 3);
        if (n % 3 == 2)
            return (int) Math.pow(3, n / 3) * 2;
        else
            return (int) Math.pow(3, n / 3 - 1) * 4;
    }

    public static void main(String[] args) {
        System.out.println(new Solution14I().cuttingRope1(10));
    }

}
