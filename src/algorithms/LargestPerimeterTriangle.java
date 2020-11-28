package algorithms;

import java.util.Arrays;

public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int a = A.length - 1; a >= 2; a--) {
            int b = a - 1, c = b - 1;
            if (A[c] > A[a] - A[b])
                return A[a] + A[b] + A[c];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = { 3, 6, 2, 3 };
        System.out.println(new LargestPerimeterTriangle().largestPerimeter(A));
    }

}
