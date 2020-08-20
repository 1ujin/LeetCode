package algorithms;

import util.Tree;
import util.TreeNode;

public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left) + 1;
        if (root.right == null) return left;
        int right = minDepth(root.right) + 1;
        if (root.left == null) return right;
        return Math.min(left, right);
    }

    public static void main(String[] args) {
        int[] vals = { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(root));
    }

}
