package algorithms;

import java.util.ArrayList;
import java.util.List;

import util.Tree;
import util.TreeNode;

public class AllElementsInTwoBinarySearchTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        List<Integer> list = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (true) {
            if (p1 == list1.size()) {
                list.addAll(list2.subList(p2, list2.size()));
                break;
            }
            if (p2 == list2.size()) {
                list.addAll(list1.subList(p1, list1.size()));
                break;
            }
            if (list1.get(p1) < list2.get(p2))
                list.add(list1.get(p1++));
            else
                list.add(list2.get(p2++));
        }
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root1 = new Tree(2, 1, 4).getRoot();
        TreeNode root2 = new Tree(1, 0, 3).getRoot();
        System.out.println(new AllElementsInTwoBinarySearchTrees()
                .getAllElements(root1, root2));
    }

}
