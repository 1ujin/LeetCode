package lcci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestLine {
    
    private class Line {
        
        public boolean v = false;
        public double k, b;
        
        public Line(Boolean v, double k, double b) {
            this.v = v;
            this.k = k;
            this.b = b;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Line)) return false;
            Line o = (Line) obj;
            return v == o.v && k == o.k && b == o.b;
        }
        
        @Override
        public int hashCode() {
            int result = Boolean.hashCode(v);
            result = result * 31 + Double.hashCode(k);
            result = result * 31 + Double.hashCode(b);
            return result;
        }
    }
    
    public int[] bestLine(int[][] points) {
        int len = points.length;
        Map<Line, int[]> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                double x1 = points[i][0], y1 = points[i][1];
                double x2 = points[j][0], y2 = points[j][1];
                Line line = null;
                if (y1 == y2) line = new Line(false, 0, y1);
                else if (x1 != x2) {
                    double k = (y1 - y2) / (x1 - x2);
                    if (k == -0) k = 0;
                    double b = (x1 * y2 - x2 * y1) / (x1 - x2);
                    if (b == -0) b = 0;
                    line = new Line(false, k, b);
                } else line = new Line(true, 0, x1);
                int ti = i, tj = j;
                map.compute(line, (k, v) -> (v == null) ?
                        new int[] {ti, tj, 1} : new int[] {v[0], v[1], ++v[2]});
            }
        }
        int[] max = {0, 0, 0};
        for (int[] v : map.values())
            max = v[2] > max[2] ? v : (v[2] == max[2] ? (v[0] < max[0] ?
                    v : (v[0] == max[0] ? (v[1] < max[1] ? v : max) : max)) : max);
        return new int[] {max[0], max[1]};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BestLine().
                bestLine(new int[][] {{0, 0}, {1, 1}, {0, 1}, {0, 2}})));
    }

}
