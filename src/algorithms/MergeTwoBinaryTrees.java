package algorithms;

import util.Tree;
import util.TreeNode;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }

    public static void main(String[] args) {
        int[] vals1 = { 1, 3, 2, 5 };
        int[] vals2 = { 2, 1, 3, Integer.MIN_VALUE, 4, Integer.MIN_VALUE, 7 };
        TreeNode t1 = new Tree(vals1).getRoot();
        TreeNode t2 = new Tree(vals2).getRoot();
        TreeNode root = new MergeTwoBinaryTrees().mergeTrees(t1, t2);
        System.out.println(TreeNode.toTreeString(root));
    }

}
