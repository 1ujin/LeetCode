package algorithms;

import java.util.HashMap;
import java.util.Map;

import util.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    
    int[] postorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        int len = postorder.length;
        for (int i = 0; i < len; i++)
            map.put(inorder[i], i);
        return dfs(len - 1, 0, len - 1);
    }

    private TreeNode dfs(int poi, int begin, int end) {
        if (begin > end) return null;
        int ioi = map.get(postorder[poi]);
        TreeNode root = new TreeNode(postorder[poi]);
        root.left = dfs(poi - 1 - end + ioi, begin, ioi - 1);
        root.right = dfs(poi - 1, ioi + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        TreeNode root = new ConstructBinaryTreeFromInorderAndPostorderTraversal()
                .buildTree(inorder, postorder);
        System.out.println(TreeNode.toTreeString(root));
    }

}
