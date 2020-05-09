package algorithms;

import java.util.Arrays;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int left = -1, right = n - 1, top = 0, bottom = n - 1;
        int num = 1, end = n * n;
        int[][] matrix = new int[n][n];
        while (num <= end) {
            for (int i = ++left; i <= right; i++)
                matrix[top][i] = num++;
            for (int i = ++top; i <= bottom; i++)
                matrix[i][right] = num++;
            for (int i = --right; i >= left; i--)
                matrix[bottom][i] = num++;
            for (int i = --bottom; i >= top; i--)
                matrix[i][left] = num++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new SpiralMatrix2().generateMatrix(3);
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

}
