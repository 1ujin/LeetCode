package algorithms;

public class ClimbingStairs {
    
    // method 1 dynamic programming
    public int climbStairs1(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]);
        return dp[n];
    }
    
    // method 2
    public int climbStairs2(int n) {
        int one = 1, two = 1, sum = 1;
        while (n-- > 0) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return one;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs1(2));
    }

}
