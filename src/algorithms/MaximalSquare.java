package algorithms;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0, h = matrix.length, w = matrix[0].length;
        for (int i = 0; i < h; i++)
            if (matrix[i][0] == '1')
                max = 1;
        for (int i = 0; i < w; i++)
            if (matrix[0][i] == '1')
                max = 1;
        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (matrix[i][j] == '1') {
                    int tmp = Math.min(matrix[i - 1][j - 1],
                            Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                    matrix[i][j] = (char) tmp;
                    tmp -= '0';
                    max = max > tmp ? max : tmp;
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = { { '1', '0', '1', '0', '0' },
                            { '1', '0', '1', '1', '1' },
                            { '1', '1', '1', '1', '1' },
                            { '1', '0', '0', '1', '0' } };
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }

}
