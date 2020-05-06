package algorithms;

import util.Tree;
import util.TreeNode;

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return dfs(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean dfs(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null || s.val != t.val) return false;
        return dfs(s.left, t.left) && dfs(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode s = new Tree(new int[] { 3, 4, 5, 1, 2 }).getRoot();
        TreeNode t = new Tree(new int[] { 4, 1, 2 }).getRoot();
        System.out.println(new SubtreeOfAnotherTree().isSubtree(s, t));
    }

}
