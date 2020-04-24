package util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Tree {
    
    private int[] vals;
    private TreeNode root;
//    private int nullCount = 0;
    
    public Tree(int[] vals) {
        this.vals = vals;
        generateByBfs(new LinkedList<>());
    }
    
    public int[] getVals() { return vals; }
    
    public TreeNode getRoot() { return root; }
    
    private void generateByBfs(Queue<TreeNode> queue) {
        if (vals.length == 0) return;
        this.root = new TreeNode(vals[0]);
        queue.offer(root);
        int index = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) continue;
            if (index < vals.length - 1) {
                if (vals[++index] == Integer.MIN_VALUE) node.left = null;
                else node.left = new TreeNode(vals[index]);
                queue.offer(node.left);
            } else break;
            if (index < vals.length - 1) {
                if (vals[++index] == Integer.MIN_VALUE) node.right = null;
                else node.right = new TreeNode(vals[index]);
                queue.offer(node.right);
            } else break;
        }
    }
    
//    private TreeNode generateByDfs(int index) {
//        if (index >= vals.length || vals[index] == Integer.MIN_VALUE) {
//            this.nullCount++;
//            return null;
//        }
//        int nullCount = this.nullCount;
//        return new TreeNode(vals[index],
//                generateByDfs(index * 2 + 1 - nullCount * 2),
//                generateByDfs(index * 2 + 2 - nullCount * 2));
//    }
    
    @Override
    public String toString() {
        return Arrays.stream(vals).boxed().collect(Collectors.toList()).stream()
                .map(i -> i == Integer.MIN_VALUE ? null : i)
                .collect(Collectors.toList()).toString();
    }

}
