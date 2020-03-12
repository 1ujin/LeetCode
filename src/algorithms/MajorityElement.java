package algorithms;

import java.util.Arrays;

public class MajorityElement {
    
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
    }

}
