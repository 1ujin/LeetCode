package algorithms;

import util.Tree;
import util.TreeNode;

public class SumRootToLeafNumbers {
    
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int num) {
        if (root == null) return;
        num = num * 10 + root.val;
        if (root.left == root.right) sum += num;
        if (root.left != null) dfs(root.left, num);
        if (root.right != null) dfs(root.right, num);
    }

    public static void main(String[] args) {
        int[] vals = { 4, 9, 0, 5, 1 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }

}
