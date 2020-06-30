package algorithms;

public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {
        int len1 = A.length, len2 = B.length, max = 0;
        int[] dp = new int[len1 + 1];
        dp[0] = 0;
        for (int i = 0; i < len2; i++) {
            for (int j = len1 - 1; j >= 0; j--) {
                if (A[j] == B[i]) {
                    dp[j + 1] = dp[j] + 1;
                    max = max > dp[j + 1] ? max : dp[j + 1];
                } else dp[j + 1] = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 2, 1 }, B = { 3, 2, 1, 4, 7 };
        System.out.println(new MaximumLengthOfRepeatedSubarray().findLength(A, B));
    }

}
