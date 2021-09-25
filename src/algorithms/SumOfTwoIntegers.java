package algorithms;

public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfTwoIntegers().getSum(1, 2));
    }

}
