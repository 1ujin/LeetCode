package util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    @Override
    public String toString() {
        List<TreeNode> list = new ArrayList<>();
        list.add(this);
        for (int i = 0; i < list.size(); i++) {
            TreeNode t = list.get(i);
            if (t == null || (t.left == null && t.right == null))
                continue;
            list.add(t.left);
            list.add(t.right);
        }
        if (list.get(list.size() - 1) == null)
            list.remove(list.size() - 1);
        return list.stream().map(n -> n == null ? null : n.val)
                .collect(Collectors.toList()).toString();
    }
}
