package algorithms;

import util.TreeNode;

public class RecoverATreeFromPreorderTraversal {
    
    char[] cs;
    int index = 0, hyphen;

    public TreeNode recoverFromPreorder(String S) {
        cs = S.toCharArray();
        return dfs(0);
    }

    private TreeNode dfs(int depth) {
        int val = 0;
        while (index < cs.length && cs[index] != '-')
            val = val * 10 + cs[index++] - '0';
        TreeNode root = new TreeNode(val);
        hyphen = 0;
        while (index < cs.length && cs[index] == '-') {
            ++hyphen;
            ++index;
        }
        if (depth < hyphen)
            root.left = dfs(depth + 1);
        if (depth < hyphen)
            root.right = dfs(depth + 1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new RecoverATreeFromPreorderTraversal()
                .recoverFromPreorder("1-401--349---90--88");
        System.out.println(TreeNode.toTreeString(root));
    }

}
