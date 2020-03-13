package lcci;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import util.Tree;
import util.TreeNode;

public class BinarySearchTreeSequences {
    
    // method 1
    private List<List<Integer>> list;
    
    public List<List<Integer>> BSTSequences1(TreeNode root) {
        list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> vals = new ArrayList<>();
        vals.add(root.val);
        dfs(root, vals);
        return list;
    }
    
    private void bfs(List<TreeNode> bfsList, List<Integer> vals) {
        List<TreeNode> tmp = new ArrayList<>();
        List<Integer> newVals = new ArrayList<>();
        newVals.addAll(vals);
        if (bfsList.size() == 0) {
            list.add(newVals);
            return;
        }
        for (TreeNode node : bfsList) {
            if (node.left != null) {
                newVals.add(node.left.val);
                tmp.add(node.left);
                dfs(node.left, newVals);
            }
            if (node.right != null) {
                newVals.add(node.right.val);
                tmp.add(node.right);
                dfs(node.right, newVals);
            }
        }
        bfs(tmp, newVals);
    }
    
    private void dfs(TreeNode node, List<Integer> vals) {
        List<TreeNode> tmp = new ArrayList<>();
        List<Integer> newVals = new ArrayList<>();
        newVals.addAll(vals);
        if (node == null) {
            list.add(newVals);
            return;
        }
        if (node.left != null) {
            newVals.add(node.left.val);
            tmp.add(node.left);
        }
        dfs(node.left, newVals);
        if (node.right != null) {
            newVals.add(node.right.val);
            tmp.add(node.right);
        }
        dfs(node.right, newVals);
        bfs(tmp, newVals);
    }
    
    // method 2
    List<List<Integer>> res;
    
    public List<List<Integer>> BSTSequences2(TreeNode root) {
        res = new LinkedList<>();
        if (root == null) {
            res.add(new LinkedList<>());
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);
        helper(root, new LinkedList<>(), path);
        return res;
    }
    
    public void helper(TreeNode root, LinkedList<TreeNode> queue, LinkedList<Integer> path){
        if (root == null) return;
        if (root.left != null) queue.add(root.left);
        if (root.right != null) queue.add(root.right);
        if (queue.isEmpty()) {
            res.add(new LinkedList<>(path));
            return;
        }
        int lens = queue.size();
        for (int i = 0; i < lens; i++){
            TreeNode cur = queue.get(i);
            queue.remove(i);         
            path.add(cur.val);
            helper(cur, new LinkedList<>(queue), path);
            queue.add(i, cur);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new Tree(new int[] {0, 1, 2, 3, 4, 5, 6}).getRoot();
        long startTime = System.nanoTime();
        List<List<Integer>> result = new BinarySearchTreeSequences().BSTSequences2(root);
        long endTime = System.nanoTime();
        System.out.println(result.size());
        for (List<Integer> list : result)
            System.out.println(list);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
