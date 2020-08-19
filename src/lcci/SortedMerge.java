package lcci;

import java.util.Arrays;

public class SortedMerge {

    public void merge(int[] A, int m, int[] B, int n) {
        while (m > 0 && n > 0)
            A[m + n - 1] = A[m - 1] > B[n - 1] ? A[--m] : B[--n];
        while (n > 0)
            A[n - 1] = B[--n];
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 0, 0, 0 }, B = { 2, 5, 6 };
        long startTime = System.nanoTime();
        new SortedMerge().merge(A, 3, B, 3);
        long endTime = System.nanoTime();
        System.out.println(Arrays.toString(A));
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
