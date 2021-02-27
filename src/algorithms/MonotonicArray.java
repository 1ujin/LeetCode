package algorithms;

public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        if (A.length < 3)
            return true;
        int flag = A[0] > A[1] ? -1 : A[0] == A[1] ? 0 : 1;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] == A[i + 1])
                continue;
            else if (flag == 0)
                flag = A[i] > A[i + 1] ? -1 : 1;
            else if (A[i] > A[i + 1] ^ flag == -1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 2, 3 };
        System.out.println(new MonotonicArray().isMonotonic(A));
    }

}
