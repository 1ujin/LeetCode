package algorithms;

public class CountVowelsPermutation {

    public int countVowelPermutation(int n) {
        long mod = 1000000007L;
        long[] dp = new long[5], tmp = new long[5];
        for (int i = 0; i < 5; i++)
            dp[i] = 1L;
        for (int i = 1; i < n; i++) {
            tmp[0] = dp[1] + dp[2] + dp[4];
            tmp[1] = dp[0] + dp[2];
            tmp[2] = dp[1] + dp[3];
            tmp[3] = dp[2];
            tmp[4] = dp[2] + dp[3];
            for (int j = 0; j < 5; j++)
                dp[j] = tmp[j] % mod;
        }
        long sum = 0L;
        for (int i = 0; i < 5; i++)
            sum += dp[i];
        return (int) (sum % mod);
    }

    public static void main(String[] args) {
        System.out.println(new CountVowelsPermutation().countVowelPermutation(20000));
    }

}
