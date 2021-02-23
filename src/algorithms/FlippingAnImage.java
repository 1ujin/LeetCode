package algorithms;

import java.util.Arrays;

public class FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int[] row : A) {
            for (int i = 0; i < n + 1 >> 1; i++) {
                int tmp = row[i] ^ 1;
                row[i] = row[n - 1 - i] ^ 1;
                row[n - 1 - i] = tmp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A = { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } };
        new FlippingAnImage().flipAndInvertImage(A);
        for (int[] row : A)
            System.out.println(Arrays.toString(row));
    }

}
