package algorithms;

import util.Tree;
import util.TreeNode;

public class BinaryTreeTilt {

    private int tilt = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return tilt;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left), right = dfs(root.right);
        tilt += Math.abs(left - right);
        return root.val + left + right;
    }

    public static void main(String[] args) {
        int[] val = { 21, 7, 14, 1, 1, 2, 2, 3, 3 };
        TreeNode root = new Tree(val).getRoot();
        System.out.println(new BinaryTreeTilt().findTilt(root));
    }

}
