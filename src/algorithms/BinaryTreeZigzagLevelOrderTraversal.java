package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import util.Tree;
import util.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean left = true;
        while (!stack.isEmpty()) {
            Stack<TreeNode> tmp = new Stack<>();
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (left) {
                    if (node.left != null) tmp.push(node.left);
                    if (node.right != null) tmp.push(node.right);
                } else {
                    if (node.right != null) tmp.push(node.right);
                    if (node.left != null) tmp.push(node.left);
                }
            }
            lists.add(list);
            stack = tmp;
            left = !left;
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] vals = { 3, 9, 20, 1 << 31, 1 << 31, 15, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }

}
