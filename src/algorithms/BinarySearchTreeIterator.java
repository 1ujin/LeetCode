package algorithms;

import java.util.Stack;

import util.Tree;
import util.TreeNode;

class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        node = node.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

public class BinarySearchTreeIterator {

    public static void main(String[] args) {
        int[] vals = { 7, 3, 15, 1 << 31, 1 << 31, 9, 20 };
        TreeNode root = new Tree(vals).getRoot();
        BSTIterator bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
    }

}
