package algorithms;

import java.util.ArrayList;
import java.util.List;

import util.Tree;
import util.TreeNode;

public class PathSum2 {
    
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return lists;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        sum -= root.val;
        if (root.left == root.right && sum == 0)
            lists.add(new ArrayList<>(list));
        dfs(root.left, sum);
        dfs(root.right, sum);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        int[] vals = { 5, 4, 8, 11, 1 << 31, 13, 4, 7, 2, 1 << 31, 1 << 31, 5, 1 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new PathSum2().pathSum(root, 22));
    }

}
