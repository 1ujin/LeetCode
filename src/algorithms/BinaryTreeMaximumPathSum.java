package algorithms;

import util.Tree;
import util.TreeNode;

public class BinaryTreeMaximumPathSum {
    
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(0, dfs(root.left));
        int rightSum = Math.max(0, dfs(root.right));
        max = Math.max(max, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        int[] vals = { -10, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }

}
