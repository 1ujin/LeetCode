package algorithms;

public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        int i = 0, patch = 0;
        long sum = 1;
        while (sum <= n) {
            if (i < nums.length && nums[i] <= sum)
                sum += nums[i++];
            else {
                sum <<= 1;
                patch++;
            }
        }
        return patch;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 10 };
        System.out.println(new PatchingArray().minPatches(nums, 20));
    }

}
