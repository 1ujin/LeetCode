package algorithms;

import java.util.ArrayList;
import java.util.List;

import util.Tree;
import util.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    
    // method 1 breadth-first search
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> tmp = new ArrayList<>();
            for (TreeNode node : level) {
                if (node != null)
                    list.add(node.val);
                if (node.left != null)
                    tmp.add(node.left);
                if (node.right != null)
                    tmp.add(node.right);
            }
            lists.add(list);
            level = tmp;
        }
        return lists;
    }
    
    // method 2 depth-first search
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        dfs(root, 0, lists);
        return lists;
    }

    private void dfs(TreeNode root, int depth, List<List<Integer>> lists) {
        if (root == null) return;
        if (lists.size() <= depth)
            lists.add(new ArrayList<>());
        lists.get(depth).add(root.val);
        dfs(root.left, depth + 1, lists);
        dfs(root.right, depth + 1, lists);
    }

    public static void main(String[] args) {
        int[] vals = { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder2(root));
    }

}
