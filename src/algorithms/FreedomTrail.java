package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FreedomTrail {
    
    // method 1 depth-first search time limit exceeded
    char[] csRing, csKey;
    int sum = 0x7fffffff;

    public int findRotateSteps1(String ring, String key) {
        csRing = ring.toCharArray();
        csKey = key.toCharArray();
        dfs(0, 0, 0);
        return sum + csKey.length;
    }

    private void dfs(int r, int k, int step) {
        if (k == csKey.length) {
            sum = step < sum ? step : sum;
            return;
        }
        if (csRing[r] == csKey[k]) {
            dfs(r, k + 1, step);
            return;
        }
        int p = 0, q = 0, i = r, j = r;
        while (true) {
            if (csRing[i] == csKey[k]) break;
            i = i == csRing.length - 1 ? 0 : ++i;
            p++;
        }
        dfs(i, k + 1, step + p);
        while (true) {
            if (csRing[j] == csKey[k]) break;
            j = j == 0 ? csRing.length - 1 : --j;
            q++;
        }
        dfs(j, k + 1, step + q);
    }

    // method 2 dynamic programming
    public int findRotateSteps2(String ring, String key) {
        char[] ringCS = ring.toCharArray(), keyCS = key.toCharArray();
        int ringLen = ringCS.length, keyLen = keyCS.length;
        @SuppressWarnings("unchecked")
        List<Integer>[] pos = new List[26];
        for (int i = 0; i < 26; i++)
            pos[i] = new ArrayList<>();
        for (int i = 0; i < ringLen; i++)
            pos[ringCS[i] - 'a'].add(i);
        int[][] dp = new int[keyLen][ringLen];
        for (int i = 0; i < keyLen; i++)
            Arrays.fill(dp[i], 0x7fffffff);
        for (int i : pos[keyCS[0] - 'a'])
            dp[0][i] = Math.min(i, ringLen - i);
        for (int i = 1; i < keyLen; i++)
            for (int j : pos[keyCS[i] - 'a'])
                for (int k : pos[keyCS[i - 1] - 'a'])
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math
                            .min(Math.abs(j - k), ringLen - Math.abs(j - k)));
        return Arrays.stream(dp[keyLen - 1]).min().getAsInt() + keyLen;
    }

    public static void main(String[] args) {
        System.out.println(new FreedomTrail().findRotateSteps2("godding", "godding"));
    }

}
