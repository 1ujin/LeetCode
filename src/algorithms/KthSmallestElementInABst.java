package algorithms;

import java.util.Stack;

import util.Tree;
import util.TreeNode;

public class KthSmallestElementInABst {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] vals = { 3, 1, 4, -1 << 31, 2 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new KthSmallestElementInABst().kthSmallest(root, 1));
    }

}
