package algorithms;

public class SearchInRotatedSortedArray {
    
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return target == nums[0] ? 0 : -1;
        int i = 0;
        int flag = 1;
        if (target < nums[i]) {
            i = nums.length - 1;
            flag = -1;
        }
        while (true) {
            if (nums[i] == target) {
                return i;
            } else {
                i += flag;
            }
            if (flag == 1 && nums[i - 1] > nums[i]) {
                return  -1;
            }
            if (flag == -1 && nums[i] > nums[i + 1]) {
                return  -1;
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int index = search(new int[] {1, 3}, 0);
        long endTime = System.nanoTime();
        System.out.println(index);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
