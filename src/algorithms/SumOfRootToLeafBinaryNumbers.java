package algorithms;

import util.Tree;
import util.TreeNode;

public class SumOfRootToLeafBinaryNumbers {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum = sum * 2 + root.val;
        if (root.left == root.right)
            return sum;
        return dfs(root.left, sum) + dfs(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = Tree.of(1, 0, 1, 0, 1, 0, 1).getRoot();
        System.out.println(new SumOfRootToLeafBinaryNumbers().sumRootToLeaf(root));
    }

}
