package algorithms;

import java.util.Arrays;

public class SortArrayByParity2 {
    
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1;
        while (true) {
            while (i < A.length && (A[i] & 1) == 0) i += 2;
            while (j < A.length && (A[j] & 1) == 1) j += 2;
            if (i >= A.length || j >= A.length) break;
            int k = A[i];
            A[i] = A[j];
            A[j] = k;
            i += 2;
            j += 2;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = { 4, 2, 5, 7 };
        System.out.println(Arrays.toString(new SortArrayByParity2().sortArrayByParityII(A)));
    }

}
