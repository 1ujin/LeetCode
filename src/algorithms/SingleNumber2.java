package algorithms;

public class SingleNumber2 {

    // method 1
    public int singleNumber1(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 0;
            for (int num : nums)
                bit += (num >> i) & 1;
            result |= bit % 3 << i;
        }
        return result;
    }

    // method 2 fastest
    public int singleNumber2(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            b = ~a & (b ^ num);
            a = ~b & (a ^ num);
        }
        return b;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 1, 0, 1, 99 };
        System.out.println(new SingleNumber2().singleNumber1(nums));
    }

}
