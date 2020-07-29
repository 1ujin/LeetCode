package algorithms;

public class IntegerBreak {
    
    // method 1 dynamic programming
    public int integerBreak1(int n) {
        int[] dp = new int[n > 5 ? n + 1 : 7];
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        for (int i = 7; i <= n; i++)
            dp[i] = dp[i - 3] * 3;
        return dp[n];
    }
    
    // method 2 greedy algorithm
    public int integerBreak2(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        return product * n;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak1(58));
    }

}
