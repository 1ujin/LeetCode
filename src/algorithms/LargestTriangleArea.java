package algorithms;

public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    int a1 = points[i][0];
                    int a2 = points[j][0] - a1;
                    int a3 = points[k][0] - a1;
                    int b1 = points[i][1];
                    int b2 = points[j][1] - b1;
                    int b3 = points[k][1] - b1;
                    maxArea = Math.max(maxArea, Math.abs(a2 * b3 - a3 * b2) / 2d);
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 0, 2 }, { 2, 0 } };
        System.out.println(new LargestTriangleArea().largestTriangleArea(points));
    }

}
