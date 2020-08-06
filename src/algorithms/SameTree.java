package algorithms;

import util.Tree;
import util.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new Tree(new int[] { 1, 2 }).getRoot();
        TreeNode q = new Tree(new int[] { 1, Integer.MIN_VALUE, 2 }).getRoot();
        System.out.println(new SameTree().isSameTree(p, q));
    }

}
