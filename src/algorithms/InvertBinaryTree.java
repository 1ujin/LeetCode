package algorithms;

import util.Tree;
import util.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public static void main(String[] args) {
        int[] vals = { 4, 2, 7, 1, 3, 6, 9 };
        TreeNode root = new Tree(vals).getRoot();
        new InvertBinaryTree().invertTree(root);
        System.out.println(TreeNode.toTreeString(root));
    }

}
