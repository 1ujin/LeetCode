package lcof;

import util.Tree;
import util.TreeNode;

public class Solution26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A != null && B != null)
            return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
        return false;
    }

    public static void main(String[] args) {
        TreeNode A = new Tree(new int[] { 3, 4, 5, 1, 2 }).getRoot();
        TreeNode B = new Tree(new int[] { 4, 1 }).getRoot();
        System.out.println(new Solution26().isSubStructure(A, B));
    }

}
