package lcof;

import util.Tree;
import util.TreeNode;

public class Solution28 {

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == right) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new Tree(new int[] { 1, 2, 2, 3, 4, 4, 3 }).getRoot();
        System.out.println(new Solution28().isSymmetric(root));
    }

}
