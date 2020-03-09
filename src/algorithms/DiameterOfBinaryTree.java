package algorithms;

import util.Tree;
import util.TreeNode;

public class DiameterOfBinaryTree {
    
    private int d;
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return d;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        d = Math.max(d, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new Tree(new int[] {1, 2}).getRoot();
        long startTime = System.nanoTime();
        int result = new DiameterOfBinaryTree().diameterOfBinaryTree(root);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
