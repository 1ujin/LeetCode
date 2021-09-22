package algorithms;

public class PowerOfThree {

    // method 1
    public boolean isPowerOfThree1(int n) {
        while (n != 0 && n % 3 == 0)
            n /= 3;
        return n == 1;
    }

    // method 2
    public boolean isPowerOfThree2(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree2(27));
    }

}
