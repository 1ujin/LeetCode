package lcci;

public class SortedMerge {
    
    public void merge(int[] A, int m, int[] B, int n) {
        while (m > 0 && n > 0)
            A[m + n - 1] = A[m - 1] > B[n - 1] ? A[m-- - 1] : B[n-- - 1];
        while (n > 0)
            A[n - 1] = B[n-- - 1];
    }

    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 3, 0, 0, 0}, B = new int[] {2, 5, 6};
        long startTime = System.nanoTime();
        new SortedMerge().merge(A, 3, B, 3);
        long endTime = System.nanoTime();
        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + ",");
        System.out.print("\nDuration: " + (endTime - startTime) + "ns");
    }

}
