package lcci;

import java.util.Arrays;

public class ClosedNumber {
    
    public int[] findClosedNumbers(int num) {
        int[] ret = new int[] {-1, -1};
        for (int i = 0; i < 32 - Integer.numberOfLeadingZeros(num) && (ret[0] == -1 || ret[1] == -1); i++) {
            if ((num >> i & 1) == 1 && (~num >> i + 1 & 1) == 1 && ret[0] == -1)
                ret[0] = ((num & ~(1 << i) | 1 << i + 1) & (-1 << i)) + ((num & (1 << i) - 1) >> Integer.numberOfTrailingZeros(num));
            if ((num >> i + 1 & 1) == 1 && (~num >> i & 1) == 1 && ret[1] == -1)
                ret[1] = (num & ~(1 << i + 1) & -1 << i) + (1 << i) + Integer.rotateLeft(Integer.reverse(num & (1 << i) - 1), i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] result = new ClosedNumber().findClosedNumbers(1156403390);
        System.out.println(Arrays.toString(result));
    }

}
