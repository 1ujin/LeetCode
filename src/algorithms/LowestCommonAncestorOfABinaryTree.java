package algorithms;

import util.Tree;
import util.TreeNode;

public class LowestCommonAncestorOfABinaryTree {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        int[] vals = { 3, 5, 1, 6, 2, 0, 8, Integer.MIN_VALUE,
                Integer.MIN_VALUE, 7, 4 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new LowestCommonAncestorOfABinaryTree()
                .lowestCommonAncestor(root, root.left, root.left.right.right));
    }

}
