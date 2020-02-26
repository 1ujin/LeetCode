package lcci;

public class ZeroMatrix {
    
    public void setZeroes(int[][] matrix) {
        int h = matrix.length, w = matrix[0].length;
        boolean delRow = false, del1stRow = false;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == 0) {
                    // 标记第一行是否清零
                    if (i == 0) del1stRow = true;
                    // 标记除第一行外的当前行是否清零
                    else delRow = true;
                    // 用第一行保存所需清零的列的下标
                    matrix[0][j] = 0;
                }
            }
            // 遍历完此行之后判断是否清零
            if (delRow && i != 0) {
                matrix[i] = new int[w];
                // 清零标记重置
                delRow = false;
            }
        }
        // 根据第一行保存的列下标清零
        for (int i = 1; i < h; i++)
            for (int j = 0; j < w; j++)
                if (matrix[0][j] == 0)
                    matrix[i][j] = 0;
        // 最后清零第一行
        if (del1stRow) matrix[0] = new int[w];
    }

    public static void main(String[] args) {
        ZeroMatrix solution = new ZeroMatrix();
        int[][] matrix = new int[][] {
            {0, 0, 0, 5},
            {4, 3, 1, 4},
            {0, 1, 1, 4},
            {1, 2, 1, 3},
            {0, 0, 1, 1},
            };
        long startTime = System.nanoTime();
        solution.setZeroes(matrix);
        long endTime = System.nanoTime();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.printf("%2d,", matrix[i][j]);
            System.out.println();
        }
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
