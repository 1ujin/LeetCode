package util;

public class Tree {
    
    private int[] vals;
    private TreeNode root;
    
    public Tree(int[] vals) {
        this.vals = vals;
        if (vals.length == 0) root = null;
        else root = generateByDfs(0);
    }
    
    public int[] getVals() { return vals; }
    
    public TreeNode getRoot() { return root; }
    
    private TreeNode generateByDfs(int index) {
        if (index >= vals.length || vals[index] < 0) return null;
        else return new TreeNode(vals[index], generateByDfs(index * 2 + 1), generateByDfs(index * 2 + 2));
    }
}
