package algorithms;

public class BinaryGap {

    public int binaryGap(int n) {
        int gap = 0;
        for (int i = 0, last = -1; n > 0; i++, n >>= 1) {
            if ((n & 1) != 1)
                continue;
            if (last != -1)
                gap = Math.max(gap, i - last);
            last = i;
        }
        return gap;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryGap().binaryGap(22));
    }

}
