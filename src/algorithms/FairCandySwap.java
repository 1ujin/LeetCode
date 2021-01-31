package algorithms;

import java.util.Arrays;

public class FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        boolean[] map = new boolean[400000];
        int diff = 0;
        for (int a : A)
            diff += a;
        for (int b : B) {
            diff -= b;
            map[199999 + b] = true;
        }
        diff >>= 1;
        for (int a : A)
            if (map[199999 + a - diff])
                return new int[] { a, a - diff };
        return null;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 5 }, B = { 2, 4 };
        System.out.println(Arrays.toString(new FairCandySwap().fairCandySwap(A, B)));
    }

}
