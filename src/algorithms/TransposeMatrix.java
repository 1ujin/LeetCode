package algorithms;

import java.util.Arrays;

public class TransposeMatrix {

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] newMatrix = new int[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                newMatrix[j][i] = matrix[i][j];
        return newMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (int[] row : new TransposeMatrix().transpose(matrix))
            System.out.println(Arrays.toString(row));
    }

}
