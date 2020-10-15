package algorithms;

import java.util.Arrays;

public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] A) {
        int len = A.length, lo = 0, hi = len - 1;
        int[] B = new int[len];
        while (lo <= hi) {
            int a = Math.abs(A[lo]) > Math.abs(A[hi]) ? A[lo++] : A[hi--];
            B[--len] = a * a;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = { -4, -1, 0, 3, 10 };
        System.out.println(Arrays.toString(new SquaresOfASortedArray().sortedSquares(A)));
    }

}
