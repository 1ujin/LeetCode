package lcci;

public class FindMajorityElement {

    // Boyer-Moore voting
    public int majorityElement(int[] nums) {
        int elem = nums[0], vote = 0;
        for (int i = 0; i < nums.length; i++) {
            if (elem == nums[i])
                vote++;
            else
                vote--;
            if (vote == 0 && i + 1 < nums.length)
                elem = nums[i + 1];
        }
        if (vote == 0) return -1;
        vote = 0;
        for (int i : nums)
            if (elem == i)
                vote++;
            else
                vote--;
        return vote > 0 ? elem : -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindMajorityElement()
                .majorityElement(new int[] { 1, 2, 5, 9, 5, 9, 5, 5, 5 }));
    }

}
