package algorithms;

import util.Tree;
import util.TreeNode;

public class InsertIntoABinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        else if (root.val > val) root.left = insertIntoBST(root.left, val);
        else if (root.val < val) root.right = insertIntoBST(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        int[] vals = { 4, 2, 7, 1, 3 };
        TreeNode root = new Tree(vals).getRoot();
        root = new InsertIntoABinarySearchTree().insertIntoBST(root, 5);
        System.out.println(TreeNode.toTreeString(root));
    }

}
