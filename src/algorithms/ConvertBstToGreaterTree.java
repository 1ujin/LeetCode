package algorithms;

import util.Tree;
import util.TreeNode;

public class ConvertBstToGreaterTree {

    // method 1
    public TreeNode convertBST1(TreeNode root) {
        dfs1(root, 0);
        return root;
    }

    private int dfs1(TreeNode root, int sum) {
        if (root == null) return sum;
        root.val += root.right == null ? sum : dfs1(root.right, sum);
        return root.left == null ? root.val : dfs1(root.left, root.val);
    }
    
    // method 2
    int sum = 0;
    
    public TreeNode convertBST2(TreeNode root) {
        dfs2(root);
        return root;
    }
    
    private TreeNode dfs2(TreeNode root) {
        if (root == null) return null;
        sum = root.val += root.right == null ? sum : dfs2(root.right).val;
        return root.left == null ? root : dfs2(root.left);
    }

    public static void main(String[] args) {
        int[] vals = { 2, 0, 3, -4, 1 };
        TreeNode root = new Tree(vals).getRoot();
        new ConvertBstToGreaterTree().convertBST2(root);
        System.out.println(TreeNode.toTreeString(root));
    }

}
