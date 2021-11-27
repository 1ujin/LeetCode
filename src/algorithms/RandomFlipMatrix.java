package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomFlipMatrix {

    private int m, n, total;
    private Map<Integer, Integer> map;

    public RandomFlipMatrix(int m, int n) {
        this.m = m;
        this.n = n;
        total = m * n;
        map = new HashMap<>();
    }

    public int[] flip() {
        int x = new Random().nextInt(total);
        total--;
        int idx = map.getOrDefault(x, x);
        map.put(x, map.getOrDefault(total, total));
        return new int[] { idx / n, idx % n };
    }

    public void reset() {
        total = m * n;
        map.clear();
    }

    public static void main(String[] args) {
        RandomFlipMatrix matrix = new RandomFlipMatrix(3, 1);
        System.out.println(Arrays.toString(matrix.flip())); // 返回 [1, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同
        System.out.println(Arrays.toString(matrix.flip())); // 返回 [2, 0]，因为 [1,0] 已经返回过了，此时返回 [2,0] 和 [0,0] 的概率应当相同
        System.out.println(Arrays.toString(matrix.flip())); // 返回 [0, 0]，根据前面已经返回过的下标，此时只能返回 [0,0]
        matrix.reset();                                     // 所有值都重置为 0 ，并可以再次选择下标返回
        System.out.println(Arrays.toString(matrix.flip())); // 返回 [2, 0]，此时返回 [0,0]、[1,0] 和 [2,0] 的概率应当相同
    }

}
