package algorithms;

public class FindTheDuplicateNumber {
    
    // method 1 binary search
    public int findDuplicate1(int[] nums) {
        int len = nums.length, lo = 1, hi = len - 1, result = -1;
        while (lo <= hi) {
            int mid = lo + hi >> 1, count = 0;
            for (int i = 0; i < len; i++)
                if (nums[i] <= mid)
                    count++;
            if (count <= mid)
                lo = mid + 1;
            else {
                hi = mid - 1;
                result = mid;
            }
        }
        return result;
    }

    // method 2 two pointer
    public int findDuplicate2(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 3, 4, 2 };
        System.out.println(new FindTheDuplicateNumber().findDuplicate1(nums));
    }

}
