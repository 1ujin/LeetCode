package algorithms;

public class FirstMissingPositive {
    
    public static int firstMissingPositive(int[] nums) {
        int i;
        int len = nums.length;
        for (i = 0; i < len; i++)
            if (nums[i] == 1)
                break;
        if (i == len) return 1; 
        if (nums.equals(new int[] {1})) return 2;
        // 用 1 填充部分不存在的正数
        for (i = 0; i < len; i++)
            if (nums[i] <= 0 || nums[i] > len)
                nums[i] = 1;
        // 利用下标代表正数，利用此下标所保存元素的正负号表示正数是否存在
        for (i = 0; i < len; i++) {
            if (Math.abs(nums[i]) == len)
                nums[0] = -Math.abs(nums[0]);
            else if (nums[Math.abs(nums[i])] > 0)
                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
        }
        for (i = 1; i < len; i++)
            if (nums[i] > 0)
                return i;
        if (nums[0] > 0) return len;
        return ++len;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int num = firstMissingPositive(new int[] {3, 4, -1, -2, 1, 5, 16, 0, 2, 0});
        long endTime = System.nanoTime();
        System.out.println(num);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
