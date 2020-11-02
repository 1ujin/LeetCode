package algorithms;

public class ValidMountainArray {
    
    public boolean validMountainArray(int[] A) {
        int i = 0, last = A.length - 1;
        for (; i < last && A[i] < A[i + 1]; i++);
        if (i == 0 || i == last || i < last && A[i] == A[i + 1]) return false;
        for (; i < last && A[i] > A[i + 1]; i++);
        if (i < last && A[i] == A[i + 1]) return false;
        return i == last;
    }

    public static void main(String[] args) {
        int[] A = { 0, 3, 2, 1 };
        System.out.println(new ValidMountainArray().validMountainArray(A));
    }

}
