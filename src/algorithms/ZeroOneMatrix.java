package algorithms;

import java.util.Arrays;

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        int h = matrix.length, w = matrix[0].length, max = h + w - 2;
        int[][] result = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == 0) continue;
                int k = 1;
                loop: for (; k <= max; k++) {
                    for (int l = 0; l < k; l++) {
                        if (i - l > -1 && j - k + l > -1 && matrix[i - l][j - k + l] == 0)
                            break loop;
                        if (i + l < h && j + k - l < w && matrix[i + l][j + k - l] == 0)
                            break loop;
                        if (j - l > -1 && i + k - l < h && matrix[i + k - l][j - l] == 0)
                            break loop;
                        if (j + l < w && i - k + l > -1 && matrix[i - k + l][j + l] == 0)
                            break loop;
                    }
                }
                if (k <= max) result[i][j] = k;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        Arrays.stream(new ZeroOneMatrix().updateMatrix(matrix))
                .map(Arrays::toString).forEach(System.out::println);
    }

}
