package algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import util.Tree;
import util.TreeNode;

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null)
                stack.push(null);
            else {
                stack.push(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        while (!stack.isEmpty() && stack.peek() == null)
            stack.pop();
        return stack.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.substring(1, data.length() - 1).split(", ");
        Queue<TreeNode> queue = new LinkedList<>();
        if (vals[0].equals("")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        queue.offer(root);
        int index = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) continue;
            if (index < vals.length - 1) {
                if (vals[++index].equals("null")) node.left = null;
                else node.left = new TreeNode(Integer.valueOf(vals[index]));
                queue.offer(node.left);
            } else break;
            if (index < vals.length - 1) {
                if (vals[++index].equals("null")) node.right = null;
                else node.right = new TreeNode(Integer.valueOf(vals[index]));
                queue.offer(node.right);
            } else break;
        }
        return root;
    }
}

public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, Integer.MIN_VALUE, Integer.MIN_VALUE, 5 };
        TreeNode root = new Tree(vals).getRoot();
        Codec codec = new Codec();
        root = codec.deserialize(codec.serialize(root));
        System.out.println(TreeNode.toTreeString(root));
    }

}
