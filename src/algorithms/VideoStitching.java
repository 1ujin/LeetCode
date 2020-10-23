package algorithms;

import java.util.Arrays;

public class VideoStitching {

    // method 1 dynamic programming
    public int videoStitching1(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, 1 << 30);
        dp[0] = 0;
        for (int i = 0; i <= T; i++)
            for (int[] clip : clips)
                if (clip[0] < i && i <= clip[1])
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
        return dp[T] == 1 << 30 ? -1 : dp[T];
    }
    
    // method 2 greedy algorithm fastest
    public int videoStitching2(int[][] clips, int T) {
        int[] max = new int[T];
        int last = 0, result = 0, prev = 0;
        for (int[] clip : clips)
            if (clip[0] < T)
                max[clip[0]] = Math.max(max[clip[0]], clip[1]);
        for (int i = 0; i < T; i++) {
            last = Math.max(last, max[i]);
            if (i == last) return -1;
            if (i == prev) {
                result++;
                prev = last;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] clips = { { 0, 4 }, { 2, 8 } };
        System.out.println(new VideoStitching().videoStitching2(clips, 5));
    }

}
