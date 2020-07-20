package algorithms;

import java.util.LinkedList;
import java.util.List;

import util.TreeNode;

public class UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {
        return n == 0 ? new LinkedList<>() : recur(1, n);
    }

    private List<TreeNode> recur(int begin, int end) {
        List<TreeNode> roots = new LinkedList<>();
        if (begin > end) {
            roots.add(null);
            return roots;
        }
        for (int i = begin; i <= end; i++) {
            List<TreeNode> lefts = recur(begin, i - 1);
            List<TreeNode> rights = recur(i + 1, end);
            for (TreeNode left : lefts)
                for (TreeNode right : rights)
                    roots.add(new TreeNode(i, left, right));
        }
        return roots;
    }

    public static void main(String[] args) {
        for (TreeNode root : new UniqueBinarySearchTrees2().generateTrees(3))
            System.out.println(TreeNode.toTreeString(root));
    }

}
