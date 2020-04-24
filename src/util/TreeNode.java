package util;

import java.util.Stack;
import java.util.stream.Collectors;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public String toString() {
        return String.valueOf(val);
    }
    
    public static String toTreeString(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        for (int i = 0; i < stack.size(); i++) {
            TreeNode t = stack.get(i);
            if (t == null)
                continue;
            stack.push(t.left);
            stack.push(t.right);
        }
        while (!stack.isEmpty() && stack.peek() == null)
            stack.pop();
        return stack.stream().map(n -> n == null ? "null" : n.val)
                .collect(Collectors.toList()).toString();
    }
}
