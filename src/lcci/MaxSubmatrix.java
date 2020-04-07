package lcci;

import java.util.Arrays;

public class MaxSubmatrix {

    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, max = matrix[0][0];
        int[] result = new int[4], dp = new int[n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp, 0);
            for (int j = i; j < m; j++) {
                dp[0] += matrix[j][0];
                int tmpMax = dp[0], tmp = tmpMax, begin = 0;
                int[] pos = {i, 0, j, 0};
                for (int k = 1; k < n; k++) {
                    dp[k] += matrix[j][k];
                    if (tmp < 0) {
                        tmp = dp[k];
                        begin = k;
                    } else tmp += dp[k];
                    if (tmp > tmpMax) {
                        tmpMax = tmp;
                        pos[1] = begin;
                        pos[3] = k;
                    }
                }
                if (tmpMax > max) {
                    max = tmpMax;
                    result = pos;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 9, -8, 1, 3, -2 }, { -3, 7, 6, -2, 4 },
                { 6, -4, -4, 8, -7 } };
        System.out.println(
                Arrays.toString(new MaxSubmatrix().getMaxMatrix(matrix)));
    }

}
