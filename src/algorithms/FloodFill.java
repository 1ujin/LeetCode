package algorithms;

import java.util.Arrays;

public class FloodFill {
    
    int[][] image;
    int h, w, oldColor, newColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        this.oldColor = image[sr][sc];
        this.newColor = newColor;
        h = image.length;
        w = image[0].length;
        dfs(sr, sc);
        return image;
    }

    private void dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= h || col >= w || image[row][col] != oldColor || image[row][col] == newColor) return;
        image[row][col] = newColor;
        dfs(row - 1, col);
        dfs(row, col - 1);
        dfs(row + 1, col);
        dfs(row, col + 1);
    }

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        System.out.println(Arrays.deepToString(new FloodFill().floodFill(image, 1, 1, 2)));
    }

}
