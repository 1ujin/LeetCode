package algorithms;

import util.Tree;
import util.TreeNode;

public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;
        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);
        int val = root.val >= low && root.val <= high ? root.val : 0;
        return val + left + right;
    }

    public static void main(String[] args) {
        int[] vals = { 10, 5, 15, 3, 7, 13, 18, 1, -1 << 31, 6 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new RangeSumOfBST().rangeSumBST(root, 6, 10));
    }

}
