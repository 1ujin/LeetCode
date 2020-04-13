package lcof;

public class Solution15 {
    
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution15()
                .hammingWeight(00000000000000000000000000001011));
    }

}
