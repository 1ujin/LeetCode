package lcci;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class ListOfDepth {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class ListNode {
        @SuppressWarnings("unused")
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    // method 1 breadth-first search
    public ListNode[] listOfDepth1(TreeNode tree) {
        if (tree == null) return new ListNode[0];
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            Queue<TreeNode> tmpQueue = new LinkedList<>();
            TreeNode head = queue.poll();
            list.add(new ListNode(head.val));
            if (head.left != null) tmpQueue.offer(head.left);
            if (head.right != null) tmpQueue.offer(head.right);
            ListNode rear = list.get(list.size() - 1);
            for (TreeNode treeNode : queue) {
                rear.next = new ListNode(treeNode.val);
                rear = rear.next;
                if (treeNode.left != null) tmpQueue.offer(treeNode.left);
                if (treeNode.right != null) tmpQueue.offer(treeNode.right);
            }
            queue = tmpQueue;
        }
        return list.toArray(new ListNode[list.size()]);
    }
    
    // method 2 depth-first search hash table slowest
    public ListNode[] listOfDepth2(TreeNode tree) {
        Map<TreeNode, Integer> map = new LinkedHashMap<>();
        dfs(map, tree, 0);
        List<ListNode> list = new ArrayList<>();
        for (Entry<TreeNode, Integer> entry : map.entrySet()) {
            int val = entry.getKey().val, index = entry.getValue();
            if (index >= list.size()) list.add(new ListNode(val));
            else {
                ListNode tmp = list.get(index);
                while (tmp.next != null) tmp = tmp.next;
                tmp.next = new ListNode(val);
            }
        }
        return list.toArray(new ListNode[list.size()]);
    }
    
    private void dfs(Map<TreeNode, Integer> map, TreeNode node, int depth) {
        if (node == null) return;
        map.put(node, depth);
        dfs(map, node.left, depth + 1);
        dfs(map, node.right, depth + 1);
    }

    public static void main(String[] args) {
        ListOfDepth solution = new ListOfDepth();
        TreeNode tree = solution.new TreeNode(1);
        tree.left = solution.new TreeNode(2);
        tree.right = solution.new TreeNode(3);
        tree.left.left = solution.new TreeNode(4);
        tree.left.right = solution.new TreeNode(5);
        tree.right.right = solution.new TreeNode(7);
        tree.left.left.left = solution.new TreeNode(8);
        
        long startTime = System.nanoTime();
        solution.listOfDepth1(tree);
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }
}