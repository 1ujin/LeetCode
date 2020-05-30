package algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length, max = 0;
        int[] left = new int[len], right = new int[len];
        Arrays.fill(right, len);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                right[stack.pop()] = i;
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < len; i++)
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        return max;
    }

    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));
    }

}
