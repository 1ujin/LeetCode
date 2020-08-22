package algorithms;

public class BitwiseAndOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return m << offset;
    }

    public static void main(String[] args) {
        System.out.println(new BitwiseAndOfNumbersRange().rangeBitwiseAnd(5, 7));
    }

}
