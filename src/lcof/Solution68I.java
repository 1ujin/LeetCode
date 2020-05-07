package lcof;

import util.Tree;
import util.TreeNode;

public class Solution68I {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val < q.val
                || root.val < p.val && root.val > q.val
                || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        int[] vals = { 6, 2, 8, 0, 4, 7, 9, Integer.MIN_VALUE,
                Integer.MIN_VALUE, 3, 5 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new Solution68I().lowestCommonAncestor(root,
                root.left.left, root.left.right.right));
    }

}
