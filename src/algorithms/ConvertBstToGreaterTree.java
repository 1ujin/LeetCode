package algorithms;

import util.Tree;
import util.TreeNode;

public class ConvertBstToGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode root, int sum) {
        root.val += root.right == null ? sum : dfs(root.right, sum);
        return root.left == null ? root.val : dfs(root.left, root.val);
    }

    public static void main(String[] args) {
        int[] vals = { 2, 0, 3, -4, 1 };
        TreeNode root = new Tree(vals).getRoot();
        new ConvertBstToGreaterTree().convertBST(root);
        System.out.println(TreeNode.toTreeString(root));
    }

}
