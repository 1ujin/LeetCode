package lcci;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumSwap {
    
    public int[] findSwapValues(int[] array1, int[] array2) {
        Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        int sum1 = 0, sum2 = 0;
        for (int i : array1) {
            sum1 += i;
            set1.add(i);
        }
        for (int i : array2) {
            sum2 += i;
            set2.add(i);
        }
        int diff = sum1 - sum2;
        if (diff % 2 != 0) return new int[0];
        diff >>= 1;
        for (int i : set1)
            if (set2.contains(i - diff))
                return new int[] {i, i - diff};
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SumSwap().findSwapValues(
                new int[] {4, 1, 2, 1, 1, 2}, new int[] {3, 6, 3, 3})));
    }

}
