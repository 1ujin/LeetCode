package algorithms;

public class SearchInRotatedSortedArray {
    
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return target == nums[0] ? 0 : -1;
        int i = 0, flag = 1;
        if (target < nums[i]) {
            i = nums.length - 1;
            flag = -1;
        }
        for (int n = 0; n < nums.length; n++) {
            if (nums[i] == target) {
                return i;
            }
            if (flag == 1 && i > 0 && nums[i - flag] > nums[i]) {
                return -1;
            }
            if (flag == -1 && i < nums.length - 1 && nums[i] > nums[i - flag]) {
                return -1;
            }
            i += flag;
        }
        return -1;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int index = search(new int[] {4, 5, 6, 7, 8, 0, 1, 2}, 3);
        long endTime = System.nanoTime();
        System.out.println(index);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
