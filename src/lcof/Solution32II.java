package lcof;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import util.Tree;
import util.TreeNode;

public class Solution32II {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        if (root != null) nodes.add(root);
        while (!nodes.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>();
            result.add(nodes.stream().map(node -> {
                if (node.left != null) tmp.add(node.left);
                if (node.right != null) tmp.add(node.right);
                return node.val;
            }).collect(Collectors.toList()));
            nodes = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] vals = { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new Solution32II().levelOrder(root));
    }

}
