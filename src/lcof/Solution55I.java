package lcof;

import util.Tree;
import util.TreeNode;

public class Solution55I {

    int max = 0;

    public int maxDepth(TreeNode root) {
        preOrder(root, 0);
        return max;
    }

    private void preOrder(TreeNode root, int depth) {
        if (root == null) return;
        max = max > ++depth ? max : depth;
        preOrder(root.left, depth);
        preOrder(root.right, depth);
    }

    public static void main(String[] args) {
        int[] vals = { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new Solution55I().maxDepth(root));
    }

}
