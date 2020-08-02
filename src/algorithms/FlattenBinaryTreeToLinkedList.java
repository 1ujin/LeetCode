package algorithms;

import util.Tree;
import util.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left, right = root.right;
        if (left != null) {
            root.left = null;
            root.right = left;
            flatten(left);
            while (left.right != null)
                left = left.right;
            left.right = right;
        }
        flatten(right);
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 5, 3, 4, Integer.MIN_VALUE, 6 };
        TreeNode root = new Tree(vals).getRoot();
        new FlattenBinaryTreeToLinkedList().flatten(root);
        System.out.println(TreeNode.toTreeString(root));
    }

}
