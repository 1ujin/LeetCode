package algorithms;

import java.util.LinkedList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            int j = i + 1, num = nums[i];
            while (j < len && nums[j] >= num) {
                nums[j - 1] = nums[j];
                j++;
            }
            nums[j - 1] = num;
            list.add(0, len - j);
        }
        list.add(0);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 9, 5, 2, 6, 1, 3 };
        System.out.println(new CountOfSmallerNumbersAfterSelf().countSmaller(nums));
    }

}
