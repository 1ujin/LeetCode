package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInAnArray {

    // method 1
    public List<Integer> findDuplicates1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            if (!set.add(num))
                list.add(num);
        return list;
    }

    // method 2
    public List<Integer> findDuplicates2(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++)
            if (nums[i] == nums[i - 1])
                list.add(nums[i++]);
        return list;
    }

    // method 3
    public List<Integer> findDuplicates3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i] - 1; nums[i] != nums[j]; j = nums[i] - 1) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] - 1 != i)
                list.add(nums[i]);
        return list;
    }

    // method 4
    public List<Integer> findDuplicates4(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int pos = Math.abs(num);
            if (nums[pos - 1] > 0)
                nums[pos - 1] = -nums[pos - 1];
            else
                list.add(pos);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(new FindAllDuplicatesInAnArray().findDuplicates4(nums));
    }

}
