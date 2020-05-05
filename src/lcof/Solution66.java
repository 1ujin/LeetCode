package lcof;

import java.util.Arrays;

public class Solution66 {

    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] b = new int[len];
        if (len == 0) return b;
        b[0] = 1;
        for (int i = 1; i < len; i++)
            b[i] = b[i - 1] * a[i - 1];
        int tmp = 1;
        for (int i = len - 2; i > -1; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(new Solution66().constructArr(a)));
    }

}
