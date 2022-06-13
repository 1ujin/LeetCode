package algorithms;

import java.util.Arrays;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] order = new int[m * n];
        for (int i = 0, idx = 0; i < m + n - 1; i++) {
            if (i % 2 == 1) {
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0)
                    order[idx++] = mat[x++][y--];
            } else {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n)
                    order[idx++] = mat[x--][y++];
            }
        }
        return order;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.toString(new DiagonalTraverse()
                .findDiagonalOrder(mat)));
    }

}
