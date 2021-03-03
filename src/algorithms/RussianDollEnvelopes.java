package algorithms;

import java.util.Arrays;

public class RussianDollEnvelopes {
    
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        if (len < 2)
            return len;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++)
                if (envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(envelopes));
    }

}
