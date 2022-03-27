package algorithms;

public class BinaryNumberWithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        int highest = Integer.MIN_VALUE;
        while ((highest & n) == 0)
            highest >>>= 1;
        while (highest > 1) {
            int high = highest & n, low = highest >>> 1 & n;
            if (high == 0 && low != 0 || high != 0 && low == 0)
                highest >>>= 1;
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryNumberWithAlternatingBits()
                .hasAlternatingBits(7));
    }

}
