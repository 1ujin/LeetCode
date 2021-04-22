package algorithms;

public class MaxSumOfRectangleNoLargerThanK {
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int h = matrix.length, w = matrix[0].length;
        int[][] sums = new int[h + 1][w + 1];
        for (int i = 1; i <= h; i++)
            for (int j = 1; j <= w; j++)
                sums[i][j] = matrix[i - 1][j - 1] + sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1];
        int max = Integer.MIN_VALUE;
        for (int i1 = 0; i1 < h; i1++) {
            for (int j1 = 0; j1 < w; j1++) {
                for (int i2 = i1 + 1; i2 <= h; i2++) {
                    for (int j2 = j1 + 1; j2 <= w; j2++) {
                        int sum = sums[i2][j2] + sums[i1][j1] - sums[i2][j1] - sums[i1][j2];
                        if (sum <= k && sum > max)
                            max = sum;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 1 },
                { 0, -2, 3 } };
        System.out.println(new MaxSumOfRectangleNoLargerThanK().maxSumSubmatrix(matrix, 2));
    }

}
