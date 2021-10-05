package algorithms;

import java.util.HashMap;
import java.util.Map;

import util.Tree;
import util.TreeNode;

public class PathSum3 {

    private int targetSum;
    private Map<Integer, Integer> map;

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        this.map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, Integer currentSum) {
        if (root == null)
            return 0;
        int count = 0;
        currentSum += root.val;
        count = map.getOrDefault(currentSum - targetSum, 0);
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        count += dfs(root.left, currentSum);
        count += dfs(root.right, currentSum);
        map.put(currentSum, map.getOrDefault(currentSum, 0) - 1);
        return count;
    }

    public static void main(String[] args) {
        int[] vals = { 10, 5, -3, 3, 2, -1 << 31, 11, 3, -2, -1 << 31, 1 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new PathSum3().pathSum(root, 8));
    }

}
