package algorithms;

import util.Tree;
import util.TreeNode;

public class NumberOfGoodLeafNodesPairs {
    
    int count = 0, distance;
    
    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        dfs(root);
        return count;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return null;
        int[] steps = new int[distance];
        if (root.left == root.right) {
            steps[0] = 1;
            return steps;
        }
        int[] leftSteps = dfs(root.left), rightSteps = dfs(root.right);
        // 提高效率，如果 null 节点返回全 0 数组则可以省略
        if (leftSteps == null || rightSteps == null) {
            System.arraycopy(leftSteps != null ? leftSteps : rightSteps, 0, steps, 1, distance - 1);
            return steps;
        }
        for (int i = 0; i < distance; i++)
            for (int j = distance - 2 - i; j >= 0; j--)
               count += leftSteps[i] * rightSteps[j];
        for (int i = 0; i < distance - 1; i++)
            steps[i + 1] = leftSteps[i] + rightSteps[i];
        return steps;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new NumberOfGoodLeafNodesPairs().countPairs(root, 3));
    }

}
