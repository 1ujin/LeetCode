package lcci;

import java.util.Arrays;

public class SmallestDifference {
    
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int diff = Integer.MAX_VALUE, tmp1 = 0, tmp2 = 0;
        for (int aptr = 0; aptr < a.length; aptr++) {
            int bptr = Arrays.binarySearch(b, a[aptr]);
            if (bptr >= 0) return 0;
            if (tmp1 >= 0 && -bptr - 2 > -1)
                tmp1 = Math.abs(a[aptr] - b[-bptr - 2]);
            if (tmp2 >= 0 && -bptr - 1 < b.length)
                tmp2 = Math.abs(a[aptr] - b[-bptr - 1]);
            diff = tmp1 > 0 && tmp1 < diff ? tmp1 : diff;
            diff = tmp2 > 0 && tmp2 < diff ? tmp2 : diff;
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(new SmallestDifference().smallestDifference(
                new int[] {1, 3, 15, 11, 2}, new int[] {23, 127, 235, 19, 8}));
    }

}
