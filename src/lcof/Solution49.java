package lcof;

public class Solution49 {
    
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int num2 = dp[a] * 2, num3 = dp[b] * 3, num5 = dp[c] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5)); 
            if (dp[i] == num2) a++;
            if (dp[i] == num3) b++;
            if (dp[i] == num5) c++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution49().nthUglyNumber(10));
    }

}
