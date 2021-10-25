package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek())
                stack.pop();
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] nums3 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
            nums3[i] = map.get(nums1[i]);
        return nums3;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 }, nums2 = { 1, 3, 4, 2 };
        System.out.println(Arrays.toString(new NextGreaterElement1().nextGreaterElement(nums1, nums2)));
    }

}
