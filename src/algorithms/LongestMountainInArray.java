package algorithms;

public class LongestMountainInArray {
    
    public int longestMountain(int[] A) {
        int len = A.length, max = 0, i = 0;
        while (i < len - 2) {
            int j = i + 1;
            if (A[i] < A[i + 1]) {
                while (j < len - 1 && A[j] < A[j + 1])
                    j++;
                if (j < len - 1 && A[j] > A[j + 1]) {
                    while (j < len - 1 && A[j] > A[j + 1])
                        j++;
                    max = Math.max(max, j - i + 1);
                } else j++;
            }
            i = j;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = { 2, 1, 4, 7, 3, 2, 5 };
        System.out.println(new LongestMountainInArray().longestMountain(A));
    }

}
