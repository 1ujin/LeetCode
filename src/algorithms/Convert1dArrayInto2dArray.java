package algorithms;

import java.util.Arrays;

public class Convert1dArrayInto2dArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n)
            return new int[][] {};
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                array[i][j] = original[i * n + j];
        return array;
    }

    public static void main(String[] args) {
        int[] original = { 1, 2, 3, 4 };
        System.out.println(Arrays.deepToString(new Convert1dArrayInto2dArray()
                .construct2DArray(original, 2, 2)));
    }

}
