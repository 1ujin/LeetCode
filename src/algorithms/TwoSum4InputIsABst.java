package algorithms;

import java.util.HashSet;
import java.util.Set;

import util.Tree;
import util.TreeNode;

public class TwoSum4InputIsABst {

    private Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new Tree(5, 3, 6, 2, 4, null, 7).getRoot();
        System.out.println(new TwoSum4InputIsABst().findTarget(root, 9));
    }

}
