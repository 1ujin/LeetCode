package lcci;

import util.Tree;
import util.TreeNode;

public class CheckSubTree {
    
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 != null) return false;
        return dfs(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }
    
    private boolean dfs(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null && t2 != null) return false;
        return t1.val == t2.val && dfs(t1.left, t2.left) && dfs(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new Tree(new int[] {1, 2, 5, 4}).getRoot();
        TreeNode t2 = new Tree(new int[] {1, 4, 5}).getRoot();
        long startTime = System.nanoTime();
        boolean result = new CheckSubTree().checkSubTree(t1, t2);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
