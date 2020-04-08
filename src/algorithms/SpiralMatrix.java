package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length < 1 || matrix[0].length < 1) return result;
        int m = matrix.length, n = matrix[0].length, beginRow = 0, beginCol = 0;
        while (m > 1 && n > 1) {
            m--;
            n--;
            int i = beginCol, j = beginRow;
            for (; j < beginCol + n; j++) result.add(matrix[i][j]);
            for (; i < beginRow + m; i++) result.add(matrix[i][j]);
            for (; j > beginCol; j--) result.add(matrix[i][j]);
            for (; i > beginRow; i--) result.add(matrix[i][j]);
            beginCol++;
            beginRow++;
            m--;
            n--;
        }
        if (m == 1)
            for (int i = beginCol; i < beginCol + n; i++)
                result.add(matrix[beginRow][i]);
        else if (n == 1)
            for (int i = beginRow; i < beginRow + m; i++)
                result.add(matrix[i][beginCol]);
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }

}
