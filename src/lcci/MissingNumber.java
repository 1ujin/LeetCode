package lcci;

public class MissingNumber {
    
    public int missingNumber(int[] nums) {
        int miss = nums.length;
        for (int i = 0; i < nums.length; i++)
            miss ^= i ^ nums[i];
        return miss;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber().
                missingNumber(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

}
