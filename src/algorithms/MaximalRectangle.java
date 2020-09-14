package algorithms;

public class MaximalRectangle {
    
    // method 1 dynamic programming
    public int maximalRectangle1(char[][] matrix) {
        int h = matrix.length;
        if (h == 0) return 0;
        int w = matrix[0].length, max = 0;
        int[][] dp = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '0') continue;
                dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                int width = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    width = dp[k][j] < width ? dp[k][j] : width;
                    max = Math.max(max, width * (i - k + 1));
                }
            }
        }
        return max;
    }
    
    // method 2 stack dynamic programming
    public int maximalRectangle2(char[][] matrix) {
        int h = matrix.length;
        if (h == 0) return 0;
        int w = matrix[0].length, max = 0;
        int[] dp = new int[w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++)
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            max = Math.max(max, new LargestRectangleInHistogram().largestRectangleArea(dp));
        }
        return max;
    }
    
    // method 3 dynamic programming fastest
    public int maximalRectangle3(char[][] matrix) {
        int h = matrix.length;
        if (h == 0) return 0;
        int w = matrix[0].length, max = 0;
        int[] left = new int[w], right = new int[w], height = new int[w];
        for (int i = 0; i < w; i++)
            right[i] = w;
        for (int i = 0; i < h; i++) {
            int cur_left = 0, cur_right = w;
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '1')
                    height[j]++;
                else height[j] = 0;
            }
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == '1')
                    left[j] = Math.max(left[j], cur_left);
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for (int j = w - 1; j >= 0; j--) {
                if (matrix[i][j] == '1')
                    right[j] = Math.min(right[j], cur_right);
                else {
                    right[j] = w;
                    cur_right = j;
                }
            }
            for (int j = 0; j < w; j++)
                max = Math.max(max, (right[j] - left[j]) * height[j]);
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(new MaximalRectangle().maximalRectangle3(matrix)); // 6
    }

}
