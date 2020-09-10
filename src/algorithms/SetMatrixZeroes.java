package algorithms;

import java.util.Arrays;

public class SetMatrixZeroes {
    
    public void setZeroes(int[][] matrix) {
        int h = matrix.length, w = matrix[0].length;
        int firstRow = 1, firstCol = 1;
        for (int i = 1; i < h; i++)
            if (matrix[i][0] == 0)
                firstRow = 0;
        for (int i = 1; i < w; i++)
            if (matrix[0][i] == 0)
                firstCol = 0;
        for (int i = 1; i < h; i++)
            for (int j = 1; j < w; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        for (int i = 1; i < h; i++)
            for (int j = 1; j < w; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
        for (int i = 0; i < h; i++)
            matrix[i][0] *= firstCol;
        for (int i = 0; i < w; i++)
            matrix[0][i] *= firstRow;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 0, 7, 8 },
                { 0, 1, 1, 2 },
                { 3, 4, 5, 0 } };
        new SetMatrixZeroes().setZeroes(matrix);
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

}
