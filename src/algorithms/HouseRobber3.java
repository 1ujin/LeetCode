package algorithms;

import util.Tree;
import util.TreeNode;

public class HouseRobber3 {

    public int rob(TreeNode root) {
        // [ 含 root, 不含 root ]
        int[] status = dfs(root);
        return Math.max(status[0], status[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null)
            return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        return new int[] { root.val + left[1] + right[1],
                Math.max(left[0], left[1]) + Math.max(right[0], right[1]) };
    }

    public static void main(String[] args) {
        int[] vals = { 3, 4, 5, 1, 3, Integer.MIN_VALUE, 1 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new HouseRobber3().rob(root));
    }

}
