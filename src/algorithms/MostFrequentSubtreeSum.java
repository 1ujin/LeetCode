package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import util.Tree;
import util.TreeNode;

public class MostFrequentSubtreeSum {

    private int count, max;
    private Map<Integer, Integer> map;

    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        dfs(root);
        int[] freq = new int[count];
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() == max)
                freq[--count] = entry.getKey();
        return freq;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int sum = root.val;
        if (root.left != null)
            sum += dfs(root.left);
        if (root.right != null)
            sum += dfs(root.right);
        int v = map.getOrDefault(sum, 0) + 1;
        if (v > max) {
            max = v;
            count = 1;
        } else if (v == max)
            count++;
        map.put(sum, v);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = Tree.of(5, 2, -3).getRoot();
        System.out.println(Arrays.toString(new MostFrequentSubtreeSum()
                .findFrequentTreeSum(root)));
    }

}
