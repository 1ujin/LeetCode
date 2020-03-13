package lcci;

import java.util.Arrays;

public class DrawLine {
    
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] ret = new int[length];
        for (int i = x1 / 32; i <= x2 / 32; i++)
            ret[i + y * w / 32] = -1;
        ret[x1 / 32 + y * w / 32] = ret[x1 / 32 + y * w / 32] & -1 >>> x1 % 32;
        ret[x2 / 32 + y * w / 32] = ret[x2 / 32 + y * w / 32] & Integer.MIN_VALUE >> x2 % 32;
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DrawLine().drawLine(1, 32, 30, 31, 0)));
    }

}
