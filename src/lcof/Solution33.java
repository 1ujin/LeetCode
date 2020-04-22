package lcof;

import java.util.Stack;

public class Solution33 {
    
    // method 1 divide and conquer
    public boolean verifyPostorder1(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int begin, int end) {
        if (begin >= end) return true;
        int i = begin, parent = postorder[end];
        while (postorder[i] < parent) i++;
        int pivot = i;
        while (postorder[i] > parent) i++;
        return i == end && recur(postorder, begin, pivot - 1)
                && recur(postorder, pivot, end - 1);
    }
    
    // method 2
    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root)
                return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] postorder = { 1, 2, 5, 10, 6, 9, 4, 3 };
        System.out.println(new Solution33().verifyPostorder2(postorder));
    }

}
