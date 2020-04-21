package lcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.Tree;
import util.TreeNode;

public class Solution32I {

    public int[] levelOrder(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            order.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        // 比声明数组并遍历列表效率慢
        return order.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] vals = { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(Arrays.toString(new Solution32I().levelOrder(root)));
    }

}
