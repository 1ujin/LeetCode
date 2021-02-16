package algorithms;

import java.util.Arrays;

public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c)
            return nums;
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int index = i * c + j;
                matrix[i][j] = nums[index / n][index % n];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2 }, { 3, 4 } };
        System.out.println(Arrays.deepToString(new ReshapeTheMatrix().matrixReshape(nums, 1, 4)));
    }

}
