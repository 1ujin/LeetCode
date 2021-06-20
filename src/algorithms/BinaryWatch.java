package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    // method 1
    public List<String> readBinaryWatch1(int turnedOn) {
        List<String> list = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(h).append(':');
                    if (m < 10)
                        sb.append('0');
                    sb.append(m);
                    list.add(sb.toString());
                }
            }
        }
        return list;
    }

    // method 2 backtracking fastest
    private static final int[] BITS = { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };
    
    public List<String> readBinaryWatch2(int turnedOn) {
        List<String> list = new ArrayList<>();
        backtrack(0, 0, 0, turnedOn, list);
        return list;
    }

    private void backtrack(int h, int m, int index, int turnedOn, List<String> list) {
        if (h > 11 || m > 59)
            return;
        if (turnedOn == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(h).append(':');
            if (m < 10)
                sb.append('0');
            sb.append(m);
            list.add(sb.toString());
            return;
        }
        turnedOn--;
        for (int i = index; i < 10; i++) {
            if (i < 4)
                backtrack(h + BITS[i], m, i + 1, turnedOn, list);
            else
                backtrack(h, m + BITS[i], i + 1, turnedOn, list);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BinaryWatch().readBinaryWatch2(1));
    }

}
