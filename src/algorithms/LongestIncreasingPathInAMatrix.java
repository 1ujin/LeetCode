package algorithms;

public class LongestIncreasingPathInAMatrix {
    
    int h, w;
    int[][] matrix, memo;

    public int longestIncreasingPath(int[][] matrix) {
        h = matrix.length;
        if (h == 0) return 0;
        w = matrix[0].length;
        this.matrix = matrix;
        memo = new int[h][w];
        int max = 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                max = Math.max(max, dfs(i, j));
        return max;
    }

    private int dfs(int i, int j) {
        if (memo[i][j] != 0)
            return memo[i][j];
        memo[i][j]++;
        int max = 0;
        if (i > 0 && matrix[i - 1][j] < matrix[i][j])
            max = Math.max(max, dfs(i - 1, j));
        if (i < h - 1 && matrix[i + 1][j] < matrix[i][j])
            max = Math.max(max, dfs(i + 1, j));
        if (j > 0 && matrix[i][j - 1] < matrix[i][j])
            max = Math.max(max, dfs(i, j - 1));
        if (j < w - 1 && matrix[i][j + 1] < matrix[i][j])
            max = Math.max(max, dfs(i, j + 1));
        memo[i][j] += max;
        return memo[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        System.out.println(new LongestIncreasingPathInAMatrix().longestIncreasingPath(matrix));
    }

}
