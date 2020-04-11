package lcof;

public class Solution10II {
    
    // method 1
    public int numWays1(int n) {
        int one = 1, two = 1, sum = 1;
        while (n-- > 0) {
            sum = (one + two) % 1000000007;
            one = two;
            two = sum;
        }
        return one;
    }
    
    // method 2 dynamic programming
    public int numWays2(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution10II().numWays2(7));
    }

}
