package lcci;

import java.util.Arrays;

public class ColorFill {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        if (sr > 0 && image[sr - 1][sc] == oldColor) floodFill(image, sr - 1, sc, newColor);
        if (sc > 0 && image[sr][sc - 1] == oldColor) floodFill(image, sr, sc - 1, newColor);
        if (sr + 1 < image.length && image[sr + 1][sc] == oldColor) floodFill(image, sr + 1, sc, newColor);
        if (sc + 1 < image[0].length && image[sr][sc + 1] == oldColor) floodFill(image, sr, sc + 1, newColor);
        return image;
    }
    
    public static void main(String[] args) {
        int[][] image = new ColorFill().floodFill(new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
        for (int[] is : image) System.out.println(Arrays.toString(is));
    }

}
