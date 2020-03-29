package lcci;

import java.util.Arrays;

public class DivingBoard {
    
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[] {};
        if (shorter == longer) return new int[] {k * shorter};
        int[] result = new int[k + 1];
        int base = shorter * k, diff = longer - shorter;
        for (int i = 0; i < result.length; i++)
            result[i] = base + diff * i;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DivingBoard().
                divingBoard(1, 2, 3)));
    }

}
