package algorithms;

public class ChalkboardXorGame {

    public boolean xorGame(int[] nums) {
        if ((nums.length & 1) == 0)
            return true;
        int xor = 0;
        for (int num : nums)
            xor ^= num;
        return xor == 0;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        System.out.println(new ChalkboardXorGame().xorGame(nums));
    }

}
