package algorithms;

import java.util.Stack;

public class TrappingRainWater {
    
    // method 1 按行累加 超时
    public static int trap1(int[] height) {
        int buffer = 0, water = 0, len = height.length;
        do {
            buffer = 0;
            int start = 0, end = 0;
            for (int i = 0; i < len; i++) {
                if (height[i] > 0) {
                    start = i;
                    break;
                }
            }
            for (int i = len - 1; i >= 0; i--) {
                if (height[i] > 0) {
                    end = i;
                    break;
                }
            }
            if (start >= end - 1) break;
            for (int i = start + 1; i < end; i++)
                if (height[i] == 0)
                    buffer++;
            for (int i = 0; i < len; i++)
                if (height[i] > 0)
                    height[i]--;
            water += buffer;
        } while (buffer < len - 1);
        return water;
    }
    
    // method 2 按列累加 时间复杂度 O(n^2)
    public static int trap2(int[] height) {
        int water = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = 0, right = 0;
            for (int j = i - 1; j >= 0; j--)
                if (height[j] > left)
                    left = height[j];
            for (int j = i + 1; j < height.length; j++)
                if (height[j] > right)
                    right = height[j];
            int current = (left < right ? left : right) - height[i];
            if (current > 0) water += current;
        }
        return water;
    }
    
    // method 3 dynamic programming
    public static int trap3(int[] height) {
        int water = 0, len = height.length;
        int[] lefts = new int[len], rights = new int[len];
        for (int i = 1; i < len; i++) {
            lefts[i] = lefts[i - 1] > height[i - 1] ? lefts[i - 1] : height[i - 1];
            rights[len - i - 1] = rights[len - i] > height[len - i] ? rights[len - i] : height[len - i]; 
        }
        for (int i = 1; i < len - 1; i++) {
            int current = (lefts[i] < rights[i] ? lefts[i] : rights[i]) - height[i];
            if (current > 0) water += current;
        }
        return water;
    }
    
    // method 4 two pointer
    public static int trap4(int[] height) {
        int water = 0, max_left = 0, max_right = 0, left = 1, right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] <= height[right + 1]) {
                max_left = height[left - 1] > max_left ? height[left - 1] : max_left;
                if (max_left > height[left]) {
                    water += (max_left - height[left]);
                }
                left++;
            } else {
                max_right = height[right + 1] > max_right ? height[right + 1] : max_right;
                if (max_right > height[right]) {
                    water += (max_right - height[right]);
                }
                right--;
            }
            if (left > right) break;
        }
        return water;
    }
    
    // method 5 stack
    public static int trap5(int[] height) {
        int water = 0, left = 0, right = 0;
        Stack<Integer> leftStack = new Stack<>();
        while (right < height.length) {
            while (!leftStack.isEmpty() && height[right] > height[left]) {
                int bottom = height[leftStack.pop()];
                if (leftStack.isEmpty()) break;
                left = leftStack.peek();
                int width = right - left - 1;
                int top = height[left] < height[right] ? height[left] : height[right];
                water += width * (top - bottom);
            }
            leftStack.push(right);
            left = leftStack.peek();
            right++;
        }
        return water;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int water = trap3(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        long endTime = System.nanoTime();
        System.out.println(water);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
