package algorithms;

public class ValidBoomerang {

    public boolean isBoomerang(int[][] points) {
        // 向量叉乘
        int[] v1 = { points[0][0] - points[1][0], points[0][1] - points[1][1] };
        int[] v2 = { points[0][0] - points[2][0], points[0][1] - points[2][1] };
        return v1[0] * v2[1] - v1[1] * v2[0] != 0;
    }

    public static void main(String[] args) {
        int[][] points = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
        System.out.println(new ValidBoomerang().isBoomerang(points));
    }

}
