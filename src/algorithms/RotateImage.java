package algorithms;

public class RotateImage {
    
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}
            };
        long startTime = System.nanoTime();
        rotate(matrix);
        long endTime = System.nanoTime();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.printf(matrix[i][j] + ", ");
            System.out.println();
        }
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
