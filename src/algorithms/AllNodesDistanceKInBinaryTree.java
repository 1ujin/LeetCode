package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Tree;
import util.TreeNode;

public class AllNodesDistanceKInBinaryTree {

    int k;
    private List<Integer> list = new ArrayList<>();
    private Map<Integer, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.k = k;
        parentDfs(root);
        dfs(target, null, 0);
        return list;
    }

    private void parentDfs(TreeNode root) {
        if (root.left != null) {
            map.put(root.left.val, root);
            parentDfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            parentDfs(root.right);
        }
    }

    private void dfs(TreeNode root, TreeNode from, int depth) {
        if (root == null)
            return;
        if (depth == k) {
            list.add(root.val);
            return;
        }
        depth++;
        // 进入左节点
        if (root.left != from)
            dfs(root.left, root, depth);
        // 进入右节点
        if (root.right != from)
            dfs(root.right, root, depth);
        // 进入父节点
        if (map.get(root.val) != from)
            dfs(map.get(root.val), root, depth);
    }

    public static void main(String[] args) {
        int[] vals = { 3, 5, 1, 6, 2, 0, 8, -1 << 31, -1 << 31, 7, 4 };
        TreeNode root = new Tree(vals).getRoot(), target = root.left;
        System.out.println(new AllNodesDistanceKInBinaryTree().distanceK(root, target, 2));
    }

}
