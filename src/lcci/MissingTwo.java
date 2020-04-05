package lcci;

import java.util.Arrays;

public class MissingTwo {

    public int[] missingTwo(int[] nums) {
        int N = nums.length, xor = 0;
        for (int i = 1; i <= N + 2; i++)
            xor ^= i;
        for (int i : nums)
            xor ^= i;
        int diff = xor & -xor, first = 0;
        for (int i = 1; i <= N + 2; i++)
            if ((diff & i) == 0)
                first ^= i;
        for (int i : nums)
            if ((diff & i) == 0)
                first ^= i;
        return new int[] {first, xor ^ first};
    }

    public static void main(String[] args) {
        System.out.println(Arrays
                .toString(new MissingTwo().missingTwo(new int[] { 2, 3 })));
    }

}
