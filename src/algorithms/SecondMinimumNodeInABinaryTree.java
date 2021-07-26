package algorithms;

import util.Tree;
import util.TreeNode;

public class SecondMinimumNodeInABinaryTree {

    private int second = -1, first;

    public int findSecondMinimumValue(TreeNode root) {
        first = root.val;
        dfs(root);
        return second;
    }

    private void dfs(TreeNode root) {
        if (root == null || second != -1 && root.val >= second)
            return;
        if (root.val != first)
            second = root.val;
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        int[] vals = { 2, 2, 5, -1 << 31, -1 << 31, 5, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new SecondMinimumNodeInABinaryTree().findSecondMinimumValue(root));
    }

}
