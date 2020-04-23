package lcof;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.Tree;
import util.TreeNode;

public class Solution34 {
    
    int SUM;
    List<List<Integer>> lists;
    Deque<Integer> deque;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        SUM = sum;
        lists = new ArrayList<>();
        deque = new LinkedList<>();
        dfs(root, 0);
        return lists;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) return;
        deque.offer(node.val);
        sum += node.val;
        if (sum == SUM && node.left == null && node.right == null)
            lists.add(new LinkedList<>(deque));
        else {
            dfs(node.left, sum);
            dfs(node.right, sum);
        }
        deque.pollLast();
    }

    public static void main(String[] args) {
        int[] vals = { 5, 4, 8, 11, Integer.MIN_VALUE, 13, 4, 7, 2,
                Integer.MIN_VALUE, Integer.MIN_VALUE, 5, 1 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new Solution34().pathSum(root, 22));
    }

}
