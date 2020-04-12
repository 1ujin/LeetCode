package algorithms;

import java.util.HashMap;
import java.util.Map;

public class SuperEggDrop {

    // brute-force search time limit exceeded
    public int superEggDrop1(int K, int N) {
        if (N == 0 || N == 1 || K == 1)
            return N;
        int min = N;
        for (int i = 1; i <= N; i++)
            min = Math.min(min, 1 + Math.max(superEggDrop1(K - 1, i - 1),
                    superEggDrop1(K, N - i)));
        return min;
    }
    
    // dynamic programming time limit exceeded
    public int superEggDrop2(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            dp[0][i] = 0;
            dp[1][i] = i;
        }
        for (int i = 2; i <= K; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int k = 2; k <= K; k++) {
            for (int n = 2; n <= N; n++) {
                for (int i = 1; i <= n; i++) {
                    int t = 1 + Math.max(dp[k - 1][i - 1], dp[k][n - i]);
                    dp[k][n] = dp[k][n] == 0 || t < dp[k][n] ? t : dp[k][n];
                }
            }
        }
        return dp[K][N];
    }
    
    // binary search
    private Map<Integer, Integer> map = new HashMap<>();
    
    public int superEggDrop3(int K, int N) {
        if (N == 0) return 0;
        if (K == 1) return N;
        // 1 <= K <= 100, 1 <= N <= 10000
        int key = N * 1000 + K;
        if (map.containsKey(key))
            return map.get(key);
        int lo = 1, hi = N;
        while (lo + 1 < hi) {
            int mi = lo + hi >>> 1;
            int f1 = superEggDrop3(K - 1, mi - 1);
            int f2 = superEggDrop3(K, N - mi);
            if (f1 < f2)
                lo = mi;
            else if (f1 > f2)
                hi = mi;
            else
                lo = hi = mi;
        }
        int min = 1 + Math.min(
                Math.max(superEggDrop3(K - 1, lo - 1),
                        superEggDrop3(K, N - lo)),
                Math.max(superEggDrop3(K - 1, hi - 1),
                        superEggDrop3(K, N - hi)));
        map.put(key, min);
        return min;
    }
    
    // dynamic programming bottom-up
    public int superEggDrop4(int K, int N) {
        int[] dp1 = new int[N + 1];
        for (int i = 0; i <= N; i++)
            dp1[i] = i;
        for (int k = 2; k <= K; k++) {
            int[] dp2 = new int[N + 1];
            int x = 1;
            for (int n = 1; n <= N; n++) {
                while (x < n && Math.max(dp1[x - 1], dp2[n - x]) > Math
                        .max(dp1[x], dp2[n - x - 1]))
                    x++;
                dp2[n] = 1 + Math.max(dp1[x - 1], dp2[n - x]);
            }
            dp1 = dp2;
        }
        return dp1[N];
    }
    
    // dynamic programming
    // https://leetcode-cn.com/problems/super-egg-drop/solution/ji-dan-diao-luo-xiang-jie-by-shellbye/123093
    public int superEggDrop5(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k - 1][m - 1] + dp[k][m - 1] + 1;
                if (dp[k][m] >= N)
                    return m;
            }
        }
        return N;
    }
    
    // dynamic programming fastest
    public int superEggDrop6(int K, int N) {
        int[] dp = new int[K + 1];
        int ans = 0;
        while (dp[K] < N) {
            for (int i = K; i > 0; i--)
                dp[i] = dp[i] + dp[i - 1] + 1;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SuperEggDrop().superEggDrop6(7, 10000));
    }

}
