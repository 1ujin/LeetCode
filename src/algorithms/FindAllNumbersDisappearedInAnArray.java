package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    
    // method 1
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        if (n < 1)
            return list;
        Arrays.sort(nums);
        int[] count = new int[Math.max(nums[n - 1], n)];
        for (int num : nums)
            count[num - 1]++;
        for (int i = 0; i < count.length; i++)
            if (count[i] == 0)
                list.add(i + 1);
        return list;
    }
    
    // method 2 fastest
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        for (int num : nums)
            nums[(num - 1) % n] += n;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (nums[i] <= n)
                list.add(i + 1);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers2(nums));
    }

}
