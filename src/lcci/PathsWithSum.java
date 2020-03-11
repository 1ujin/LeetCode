package lcci;

import java.util.HashSet;
import java.util.Set;

import util.Tree;
import util.TreeNode;

public class PathsWithSum {
    
    private int COUNT = 0;
    private int SUM;
    private Set<TreeNode> SET;
    
    public int pathSum(TreeNode root, int sum) {
        SUM = sum;
        SET = new HashSet<>();
        dfs(root, 0);
        return COUNT;
    }
    
    private void dfs(TreeNode node, int sum) {
        if (node == null) return;
        sum += node.val;
        if (sum == SUM) COUNT++;
        dfs(node.left, sum);
        dfs(node.right, sum);
        if (!SET.add(node)) return;
        dfs(node.left, 0);
        dfs(node.right, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new Tree(new int[] {5, 4, 8, 11, Integer.MIN_VALUE, 13, 4, 7, 2, Integer.MIN_VALUE, Integer.MIN_VALUE, 5, 1}).getRoot();
//        TreeNode root = new Tree(new int[] {1,-2,-3,1,3,-2,Integer.MIN_VALUE,-1}).getRoot();
//        TreeNode root = new Tree(new int[] {1,-2,-3,1,3,-2,Integer.MIN_VALUE,-1}).getRoot();
//        TreeNode root = new Tree(new int[] {0, 1, 1}).getRoot();
        long startTime = System.nanoTime();
        int result = new PathsWithSum().pathSum(root, 22);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
