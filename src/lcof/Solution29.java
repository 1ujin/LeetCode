package lcof;

import java.util.Arrays;

public class Solution29 {
    
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int h = matrix.length, w = matrix[0].length;
        int[] output = new int[h * w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int n = Math.min(Math.min(i, h - 1 - i), Math.min(j, w - 1 - j));
                int offset = (h + w - (n << 1)) * n << 1;
                if (i == n) output[offset + j - n] = matrix[i][j];
                else if (w - 1 - j == n) output[offset + w - 1 - n * 3 + i] = matrix[i][j];
                else if (h - 1 - i == n) output[offset + w * 2 + h - 3 - n * 5 - j] = matrix[i][j];
                else output[offset + w * 2 + h * 2 - 4 - n * 7 - i] = matrix[i][j];
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.toString(new Solution29().spiralOrder(matrix)));
    }

}
