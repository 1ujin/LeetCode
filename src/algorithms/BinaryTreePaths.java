package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import util.Tree;
import util.TreeNode;

public class BinaryTreePaths {
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        return dfs(root).stream().map(s -> {
            s.delete(0, 2);
            return s.toString();
        }).collect(Collectors.toList());
    }

    private List<StringBuilder> dfs(TreeNode root) {
        List<StringBuilder> paths = new ArrayList<>();
        if (root.left == root.right)
            paths.add(new StringBuilder());
        if (root.left != null)
            paths.addAll(dfs(root.left));
        if (root.right != null)
            paths.addAll(dfs(root.right));
        for (StringBuilder sb : paths) {
            sb.insert(0, root.val);
            sb.insert(0, "->");
        }
        return paths;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, Integer.MIN_VALUE, 5 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new BinaryTreePaths().binaryTreePaths(root));
    }

}
