package lcci;

public class SortedMatrixSearch {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m < 1) return false;
        int n = matrix[0].length;
        if (n < 1) return false;
        int i = 0, j = n - 1;
        while (i < m && j > -1) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SortedMatrixSearch().searchMatrix(new int[][] {
            { 1,  4,  7, 11, 15},
            { 2,  5,  8, 12, 19},
            { 3,  6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        }, 5));
    }

}
