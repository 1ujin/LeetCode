package lcci;

public class MagicIndex {
    
    // method 1
    public int findMagicIndex1(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == i) return i;
        return -1;
    }
    
    // method 2 dichotomy
    public int findMagicIndex2(int[] nums) {
        int magic = dichotomy(0, nums.length - 1, nums);
        return magic == Integer.MAX_VALUE ? -1 : magic;
    }

    private int dichotomy(int left, int right, int[] nums) {
        int ret = Integer.MAX_VALUE;
        if (left <= right) {
            int mid = (left + right) / 2;
            ret = nums[mid] == mid ? mid : ret;
            int leftRet = dichotomy(left, mid - 1, nums);
            int rightRet = dichotomy(mid + 1, right, nums);
            ret = leftRet != Integer.MAX_VALUE && leftRet < ret ? leftRet : ret;
            ret = rightRet != Integer.MAX_VALUE && rightRet < ret ? rightRet : ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new MagicIndex().findMagicIndex2(new int[] {0, 2, 3, 4, 5}));
    }

}
