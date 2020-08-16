package algorithms;

import util.Tree;
import util.TreeNode;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return root == null || Math.abs(dfs(root.left) - dfs(root.right)) < 2
                && isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }

    public static void main(String[] args) {
        int[] vals = { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new BalancedBinaryTree().isBalanced(root));
    }

}
