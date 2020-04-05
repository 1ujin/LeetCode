package lcci;

public class VolumeOfHistogram {
    
    // method 1 two pointer
    public int trap1(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, sum = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                sum += leftMax;
                left++;
            } else if (leftMax > rightMax) {
                sum += rightMax;
                right--;
            } else {
                sum += leftMax;
                if (left != right) sum += rightMax;
                left++;
                right--;
            }
        }
        for (int i : height)
            sum -= i;
        return sum;
    }
    
    // method 2 dynamic programming
    public int trap2(int[] height) {
        int len = height.length, water = 0;
        int[] lefts = new int[len], rights = new int[len];
        for (int i = 1; i < len; i++) {
            lefts[i] = Math.max(lefts[i - 1], height[i - 1]);
            rights[len - 1 - i] = Math.max(rights[len - i], height[len - i]);
        }
        for (int i = 1; i < len - 1; i++)
            water += Math.max(0, Math.min(lefts[i], rights[i]) - height[i]);
        return water;
    }

    public static void main(String[] args) {
        System.out.println(new VolumeOfHistogram()
                .trap1(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

}
