package algorithms;

public class DecodeWays {
    
    public int numDecodings(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (cs[i - 1] != '0')
                dp[i] = dp[i - 1];
            if (i > 1 && cs[i - 2] != '0' && (cs[i - 2] - '0') * 10 + cs[i - 1] - '0' <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("11106"));
    }

}
