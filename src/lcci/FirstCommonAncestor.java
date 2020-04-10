package lcci;

import util.Tree;
import util.TreeNode;

public class FirstCommonAncestor {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == q) return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null || root == p || root == q) return root;
        if (left != null || right != null) return left != null ? left : right;
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new Tree(new int[] {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4}).getRoot();
        long startTime = System.nanoTime();
        int result = new FirstCommonAncestor().lowestCommonAncestor(root, root.left.right, root.right).val;
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
