package lcof;

import util.Tree;
import util.TreeNode;

public class Solution54 {

    int k, val;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return val;
    }

    private void inOrder(TreeNode root) {
        if (k > 0 && root.right != null)
            inOrder(root.right);
        if (k-- == 1)
            val = root.val;
        if (k > 0 && root.left != null)
            inOrder(root.left);
    }

    public static void main(String[] args) {
        int[] vals = { 3, 1, 4, Integer.MIN_VALUE, 2 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new Solution54().kthLargest(root, 1));
    }

}
