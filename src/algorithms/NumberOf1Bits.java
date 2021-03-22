package algorithms;

public class NumberOf1Bits {
    
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().hammingWeight(0b11111111111111111111111111111101));
    }

}
