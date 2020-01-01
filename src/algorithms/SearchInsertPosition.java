package algorithms;

public class SearchInsertPosition {
    
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        /*
         * 右侧边界初值取为nums.length，由于除法（右移）运算只舍不进，中间值在循环范围内永远取不到超出数组下标范围的值，
         * 如果中间值取到数组下标范围外，说明左边界值已经超出数组下标范围（left = right = nums.length），此时已经跳出循环
         */
        int left = 0, right = nums.length;
        while (left < right) {
            // 无符号右移
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int position = searchInsert(new int[] {0, 1, 2, 3}, 4);
        long endTime = System.nanoTime();
        System.out.println(position);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
