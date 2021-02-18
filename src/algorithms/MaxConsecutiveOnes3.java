package algorithms;

public class MaxConsecutiveOnes3 {

    public int longestOnes(int[] A, int K) {
        int max = 0;
        for (int left = 0, right = 0, zero = 0; right < A.length; right++) {
            if (A[right] == 0)
                zero++;
            while (zero > K)
                if (A[left++] == 0)
                    zero--;
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        System.out.println(new MaxConsecutiveOnes3().longestOnes(A, 3));
    }

}
