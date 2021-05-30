package algorithms;

public class PowerOfFour {

    public boolean isPowerOfFour(int n) {
        return n > 0 && Integer.bitCount(n) == 1
                && Integer.numberOfTrailingZeros(n) % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfFour().isPowerOfFour(4));
    }

}
