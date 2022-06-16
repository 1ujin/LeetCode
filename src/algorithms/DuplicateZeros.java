package algorithms;

import java.util.Arrays;

public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int zero = 0, len = arr.length, i = len - 1;
        for (int a : arr)
            if (a == 0)
                zero++;
        i += zero;
        zero <<= 1;
        for (; i >= 0; i--) {
            int offset = zero / 2;
            if (arr[i - offset] == 0)
                zero--;
            if (i >= len)
                continue;
            arr[i] = arr[i - offset];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 3, 0, 4, 5, 0 };
        new DuplicateZeros().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

}
