package lcof;

import util.Tree;
import util.TreeNode;

public class Solution27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new Tree(new int[] { 4, 2, 7, 1, 3, 6, 9 }).getRoot();
        System.out.println(TreeNode.toTreeString(new Solution27().mirrorTree(root)));
    }

}
