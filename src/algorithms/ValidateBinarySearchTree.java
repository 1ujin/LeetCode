package algorithms;

import util.Tree;
import util.TreeNode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode maxLeft = root.left, minRight = root.right;
        // 找寻左子树中的最右（数值最大）节点
        while (maxLeft != null && maxLeft.right != null)
            maxLeft = maxLeft.right;
        // 找寻右子树中的最左（数值最小）节点
        while (minRight != null && minRight.left != null)
            minRight = minRight.left;
        // 当前层是否合法
        return (maxLeft == null || maxLeft.val < root.val)
                && (minRight == null || minRight.val > root.val)
                // 进入左子树和右子树并判断是否合法
                && isValidBST(root.left) && isValidBST(root.right);
    }

    public static void main(String[] args) {
        int[] vals = { 5, 1, 4, Integer.MIN_VALUE, Integer.MIN_VALUE, 3, 6 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }

}
