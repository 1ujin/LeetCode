package algorithms;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A)
            for (int b : B)
                map.compute(a + b, (k, v) -> v == null ? 1 : ++v);
        int count = 0;
        for (int c : C)
            for (int d : D)
                count += map.getOrDefault(-(c + d), 0);
        return count;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2 }, B = { -2, -1 }, C = { -1, 2 }, D = { 0, 2 };
        System.out.println(new FourSum2().fourSumCount(A, B, C, D));
    }

}
