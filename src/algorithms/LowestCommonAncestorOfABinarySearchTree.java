package algorithms;

import util.Tree;
import util.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    
    // method 1 fastest
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor1(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor1(root.right, p, q);
        return root;
    }
    
    // method 2
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        int[] vals = { 6, 2, 8, 0, 4, 7, 9, 1 << 31, 1 << 31, 3, 5 };
        TreeNode root = new Tree(vals).getRoot();
        TreeNode p = new TreeNode(2), q = new TreeNode(4);
        System.out.println(new LowestCommonAncestorOfABinarySearchTree()
                .lowestCommonAncestor1(root, p, q));
    }

}
