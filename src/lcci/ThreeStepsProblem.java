package lcci;

public class ThreeStepsProblem {
    
    // dynamic programming top-down time limit exceeded
    public int waysToStep(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        return (waysToStep(n - 1) + waysToStep(n - 2) + waysToStep(n - 3)) % 1000000007;
    }
    
    // method 1 dynamic programming bottom-up
    public int waysToStep1(int n) {
        long[] dp;
        if (n < 3) dp = new long[3];
        else dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++)
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007;
        return (int) dp[n];
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int result = new ThreeStepsProblem().waysToStep1(61);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
