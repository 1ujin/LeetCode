package algorithms;

import java.util.Arrays;

public class MaximumHeightByStackingCuboids {
    
    public int maxHeight(int[][] cuboids) {
        int len = cuboids.length, max = 0;
        Integer[] index = new Integer[len * 6];
        for (int i = 0; i < len * 6; i++)
            index[i] = i;
        int[][] Cuboids = new int[len * 6][3];
        int[][] orders = { { 0, 1, 2 }, { 1, 2, 0 }, { 2, 0, 1 },
                { 1, 0, 2 }, { 0, 2, 1 }, { 2, 1, 0 } };
        for (int i = 0; i < len; i++)
            for (int j = 0; j < 6; j++)
                for (int k = 0; k < 3; k++)
                    Cuboids[6 * i + j][k] = cuboids[i][orders[j][k]];
        Arrays.sort(index,
                (a, b) -> Cuboids[a][0] != Cuboids[b][0]
                        ? Cuboids[a][0] - Cuboids[b][0]
                        : Cuboids[a][1] != Cuboids[b][1]
                                ? Cuboids[a][1] - Cuboids[b][1]
                                : Cuboids[a][2] - Cuboids[b][2]);
        int[] dp = new int[len * 6];
        for (int i = 0; i < len * 6; i++) {
            int h = 0;
            for (int j = 0; j < i; j++)
                if (index[i] / 6 != index[j] / 6
                        && Cuboids[index[i]][1] >= Cuboids[index[j]][1]
                        && Cuboids[index[i]][2] >= Cuboids[index[j]][2]
                        && dp[j] > h)
                    h = dp[j];
            dp[i] = Cuboids[index[i]][2] + h;
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] cuboids = { { 7, 11, 17 }, { 7, 17, 11 }, { 11, 7, 17 },
                { 11, 17, 7 }, { 17, 7, 11 }, { 17, 11, 7 } };
        System.out.println(new MaximumHeightByStackingCuboids().maxHeight(cuboids));
    }

}
