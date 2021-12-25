package algorithms;

import java.util.Stack;

import util.Tree;
import util.TreeNode;

public class EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int level = 0;
        while (!stack.isEmpty()) {
            Stack<TreeNode> tmp = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if ((node.val & 1) == (level & 1))
                    return false;
                if (!stack.isEmpty() && node.val <= stack.peek().val)
                    return false;
                if (level % 2 == 0) {
                    if (node.right != null)
                        tmp.push(node.right);
                    if (node.left != null)
                        tmp.push(node.left);
                } else {
                    if (node.left != null)
                        tmp.push(node.left);
                    if (node.right != null)
                        tmp.push(node.right);
                }
            }
            stack = tmp;
            level++;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new Tree(1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2).getRoot();
        System.out.println(new EvenOddTree().isEvenOddTree(root));
    }

}
