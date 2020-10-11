package algorithms;

import util.Tree;
import util.TreeNode;

public class MinimumAbsoluteDifferenceInBst {
    
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = dfs(root.left), right = dfs(root.right);
        if (root.left == null) left[0] = root.val;
        else min = Math.min(min, root.val - left[1]);
        if (root.right == null) right[1] = root.val;
        else min = Math.min(min, right[0] - root.val);
        return new int[] { left[0], right[1] };
    }

    public static void main(String[] args) {
        int[] vals = { 1, 1 << 31, 3, 2 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new MinimumAbsoluteDifferenceInBst().getMinimumDifference(root));
    }

}
