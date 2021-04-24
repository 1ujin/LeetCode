package algorithms;

import util.Tree;
import util.TreeNode;

public class IncreasingOrderSearchTree {

    // method 1
    private TreeNode dummy = new TreeNode(-1), prev = dummy;

    public TreeNode increasingBST1(TreeNode root) {
        if (root == null)
            return null;
        increasingBST1(root.left);
        prev.right = root;
        root.left = null;
        prev = prev.right;
        increasingBST1(root.right);
        return dummy.right;
    }

    // method 2
    public TreeNode increasingBST2(TreeNode root) {
        TreeNode dummy = new TreeNode(-1, null, root);
        inorder(dummy);
        return dummy.right;
    }

    private TreeNode inorder(TreeNode root) {
        if (root.left != null) {
            inorder(root.left).right = root;
            root.left = null;
        }
        if (root.right == null)
            return root;
        TreeNode right = root.right, next = right;
        while (next.left != null)
            next = next.left;
        root.right = next;
        return inorder(right);
    }

    public static void main(String[] args) {
        int[] vals = { 5, 3, 6, 2, 4, -1 << 31, 8, 1, -1 << 31, -1 << 31, -1 << 31, 7, 9 };
        TreeNode root = new Tree(vals).getRoot();
        root = new IncreasingOrderSearchTree().increasingBST2(root);
        System.out.println(TreeNode.toTreeString(root));
    }

}
