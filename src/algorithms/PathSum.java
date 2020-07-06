package algorithms;

import util.Tree;
import util.TreeNode;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) return true;
        else return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        int[] vals = { 5, 4, 8, 11, Integer.MIN_VALUE, 13, 4, 7, 2,
                Integer.MIN_VALUE, Integer.MIN_VALUE, 5, 1 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new PathSum().hasPathSum(root, 22));
    }

}
