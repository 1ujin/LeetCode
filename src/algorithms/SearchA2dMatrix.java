package algorithms;

public class SearchA2dMatrix {
    
    // method 1 binary search
    public boolean searchMatrix1(int[][] matrix, int target) {
        int h = matrix.length;
        if (h == 0) return false;
        int w = matrix[0].length;
        int lo = 0, hi = h * w - 1;
        while (lo <= hi) {
            int mid = lo + hi >> 1;
            int pivot = matrix[mid / w][mid % w];
            if (pivot < target) lo = ++mid;
            else if (pivot > target) hi = --mid;
            else return true;
        }
        return false;
    }
    
    // method 2
    public boolean searchMatrix2(int[][] matrix, int target) {
        int h = matrix.length;
        if (h == 0) return false;
        int w = matrix[0].length;
        int i = 0, j = w - 1;
        while (0 <= i && i < h && 0 <= j && j < w) {
            if (matrix[i][j] < target) i++;
            else if (matrix[i][j] > target) j--;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {  1,  3,  5,  7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 50 } };
        System.out.println(new SearchA2dMatrix().searchMatrix1(matrix, 3));
    }

}
