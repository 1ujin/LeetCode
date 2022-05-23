package algorithms;

import util.Tree;
import util.TreeNode;

public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null || root.left == root.right)
            return true;
        if (root.left != null && root.val != root.left.val)
            return false;
        if (root.right != null && root.val != root.right.val)
            return false;
        if (root.left != null && root.right != null
                && root.left.val != root.right.val)
            return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = Tree.of(1, 1, 1, 1, 1, null, 1).getRoot();
        System.out.println(new UnivaluedBinaryTree().isUnivalTree(root));
    }

}
