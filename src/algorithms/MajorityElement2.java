package algorithms;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {
        int elem1 = 0, elem2 = 0, vote1 = 0, vote2 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && elem1 == num)
                vote1++;
            else if (vote2 > 0 && elem2 == num)
                vote2++;
            else if (vote1 == 0) {
                elem1 = num;
                vote1++;
            } else if (vote2 == 0) {
                elem2 = num;
                vote2++;
            } else {
                vote1--;
                vote2--;
            }
        }
        for (int num : nums) {
            if (vote1 > 0 && elem1 == num)
                count1++;
            if (vote2 > 0 && elem2 == num)
                count2++;
        }
        List<Integer> list = new ArrayList<>();
        if (count1 > nums.length / 3)
            list.add(elem1);
        if (count2 > nums.length / 3)
            list.add(elem2);
        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 3, 2, 2, 2 };
        System.out.println(new MajorityElement2().majorityElement(nums));
    }

}
