package algorithms;

import java.util.Arrays;

public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        int h = dungeon.length, w = dungeon[0].length;
        int[][] dp = new int[h + 1][w + 1];
        for (int[] is : dp)
            Arrays.fill(is, Integer.MAX_VALUE);
        dp[h - 1][w] = dp[h][w - 1] = 1;
        for (int i = h - 1; i >= 0; i--)
            for (int j = w - 1; j >= 0; j--)
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
        System.out.println(new DungeonGame().calculateMinimumHP(dungeon));
    }

}
