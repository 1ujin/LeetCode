package algorithms;

public class MaxPointsOnALine {

    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len <= 2)
            return len;
        int maxPoint = 1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int count = 2;
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                int deltaX = x2 - x1, deltaY = y2 - y1;
                for (int k = j + 1; k < len; k++) {
                    int x3 = points[k][0], y3 = points[k][1];
                    if ((y3 - y1) * deltaX == (x3 - x1) * deltaY)
                        count++;
                }
                maxPoint = count > maxPoint ? count : maxPoint;
            }
        }
        return maxPoint;
    }

    public static void main(String[] args) {
        int[][] points = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
        System.out.println(new MaxPointsOnALine().maxPoints(points));
    }

}
