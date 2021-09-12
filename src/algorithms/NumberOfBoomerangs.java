package algorithms;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int number = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point1 : points) {
            for (int[] point2 : points) {
                int dist = (point1[0] - point2[0]) * (point1[0] - point2[0])
                        + (point1[1] - point2[1]) * (point1[1] - point2[1]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int v : map.values())
                number += v * (v - 1);
            map.clear();
        }
        return number;
    }

    public static void main(String[] args) {
        int[][] points = { { 0, 0 }, { 1, 0 }, { 2, 0 } };
        System.out.println(new NumberOfBoomerangs().numberOfBoomerangs(points));
    }

}
