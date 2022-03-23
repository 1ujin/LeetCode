package algorithms;

import java.util.Arrays;

public class ImageSmoother {

    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0, sum = 0;
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            num++;
                            sum += img[x][y];
                        }
                    }
                }
                result[i][j] = sum / num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] img = { { 100, 200, 100 }, { 200, 50, 200 },
                { 100, 200, 100 } };
        System.out.println(Arrays.deepToString(new ImageSmoother()
                .imageSmoother(img)));
    }

}
