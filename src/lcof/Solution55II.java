package lcof;

import util.Tree;
import util.TreeNode;

public class Solution55II {
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(maxHeight(root.left) - maxHeight(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        int[] vals = { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new Solution55II().isBalanced(root));
    }

}
