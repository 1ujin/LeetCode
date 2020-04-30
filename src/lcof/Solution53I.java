package lcof;

public class Solution53I {

    public int search(int[] nums, int target) {
        int count = 0, len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0] == target ? 1 : 0;
        int lo = 0, hi = len - 1;
        while (lo + 1 < hi) {
            int mid = lo + hi >> 1;
            if (nums[mid] < target)
                lo = mid;
            else
                hi = mid;
        }
        while (lo > -1 && nums[lo--] == target)
            count++;
        while (hi < len && nums[hi++] == target)
            count++;
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        System.out.println(new Solution53I().search(nums, 8));
    }

}
