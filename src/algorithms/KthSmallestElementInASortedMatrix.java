package algorithms;

public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + right >> 1, i = n - 1, j = 0, count = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] <= mid) {
                    count += i + 1;
                    j++;
                } else i--;
            }
            if (count < k) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        System.out.println(new KthSmallestElementInASortedMatrix().kthSmallest(matrix, 8));
    }

}
