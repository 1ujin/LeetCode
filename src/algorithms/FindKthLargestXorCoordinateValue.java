package algorithms;

import java.util.Arrays;

public class FindKthLargestXorCoordinateValue {

    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[(m + 1) * (n + 1)];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int index = i * (n + 1) + j;
                dp[index] = dp[index - n - 2] ^ dp[index - n - 1]
                        ^ dp[index - 1] ^ matrix[i - 1][j - 1];
            }
        }
        Arrays.sort(dp);
        return dp[(m + 1) * (n + 1) - k];
    }

    public static void main(String[] args) {
        int[][] matrix = { { 5, 2 }, { 1, 6 } };
        System.out.println(new FindKthLargestXorCoordinateValue()
                .kthLargestValue(matrix, 4));
    }

}
