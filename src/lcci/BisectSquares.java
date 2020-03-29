package lcci;

import java.util.Arrays;

public class BisectSquares {
    
    public double[] cutSquares(int[] square1, int[] square2) {
        double[] result = new double[4];
        double[] ctr1 = {square1[0] + (double) square1[2] / 2,
                square1[1] + (double) square1[2] / 2};
        double[] ctr2 = {square2[0] + (double) square2[2] / 2,
                square2[1] + (double) square2[2] / 2};
        double bottom = Math.min(square1[1], square2[1]);
        double top = Math.max(square1[1] + square1[2], square2[1] + square2[2]);
        double left = Math.min(square1[0], square2[0]);
        double right = Math.max(square1[0] + square1[2], square2[0] + square2[2]);
        if (ctr1[0] - ctr2[0] == 0)
            return new double[] {ctr1[0], bottom, ctr1[0], top};
        double k = (ctr1[1] - ctr2[1]) / (ctr1[0] - ctr2[0]);
        if (k <= 1 && k >= -1) {
            result[0] = left;
            result[2] = right;
            result[1] = (left - ctr2[0]) * (ctr1[1] - ctr2[1]) /
                    (ctr1[0] - ctr2[0]) + ctr2[1];
            result[3] = (right - ctr2[0]) * (ctr1[1] - ctr2[1]) /
                    (ctr1[0] - ctr2[0]) + ctr2[1];
        } else {
            double t1 = (top - ctr2[1]) * (ctr1[0] - ctr2[0]) /
                    (ctr1[1] - ctr2[1]) + ctr2[0];
            double t2 = (bottom - ctr2[1]) * (ctr1[0] - ctr2[0]) /
                    (ctr1[1] - ctr2[1]) + ctr2[0];
            result[0] = Math.min(t1, t2);
            result[2] = Math.max(t1, t2);
            result[1] = t1 <= t2 ? top : bottom;
            result[3] = t1 <= t2 ? bottom : top;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] square1 = {249, -199, 5};
        int[] square2 = {-1, 136, 76};
        System.out.println(Arrays.toString(new BisectSquares().
                cutSquares(square1, square2)));
    }

}
