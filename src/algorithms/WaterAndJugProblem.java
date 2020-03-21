package algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WaterAndJugProblem {

    // method 1
    public boolean canMeasureWater1(int x, int y, int z) {
        if (x + y < z)
            return false;
        if (x == 0 || y == 0)
            return z == 0 || x + y == z;
        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
    
    // method 2 depth-first search
    public boolean canMeasureWater2(int x, int y, int z) {
        if (z < 0 || z > x + y) return false;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            if (n + x <= x + y && set.add(n + x))
                queue.offer(n + x);
            if (n + y <= x + y && set.add(n + y))
                queue.offer(n + y);
            if (n - x >= 0 && set.add(n - x))
                queue.offer(n - x);
            if (n - y >= 0 && set.add(n - y))
                queue.offer(n - y);
            if (set.contains(z)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WaterAndJugProblem().canMeasureWater2(5, 3, 4));
    }

}
