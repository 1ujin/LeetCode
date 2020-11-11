package algorithms;

public class GetMaximumInGeneratedArray {
    
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        int[] nums = new int[n + 1];
        nums[1] = 1;
        int i = 1, max = 1;
        while (++i <= n) {
            nums[i] = nums[i >> 1] + ((i & 1) == 0 ? 0 : nums[i + 1 >> 1]);
            max = nums[i] > max ? nums[i] : max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new GetMaximumInGeneratedArray().getMaximumGenerated(7));
    }

}
