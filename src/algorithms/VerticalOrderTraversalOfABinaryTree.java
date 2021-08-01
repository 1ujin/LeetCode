package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import util.Tree;
import util.TreeNode;

public class VerticalOrderTraversalOfABinaryTree {

    private PriorityQueue<int[]> queue;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        queue = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2] && a[1] == b[1])
                return a[0] - b[0];
            else if (a[2] != b[2])
                return a[2] - b[2];
            else
                return a[1] - b[1];
        });
        dfs(root, 0, 0);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        lists.add(list);
        int[] last = queue.poll();
        list.add(last[0]);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[2] != last[2]) {
                list = new ArrayList<>();
                lists.add(list);
                last = current;
            }
            list.add(current[0]);
        }
        return lists;
    }

    private void dfs(TreeNode root, int row, int col) {
        if (root == null)
            return;
        queue.offer(new int[] { root.val, row, col });
        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new VerticalOrderTraversalOfABinaryTree()
                .verticalTraversal(root));
    }

}
