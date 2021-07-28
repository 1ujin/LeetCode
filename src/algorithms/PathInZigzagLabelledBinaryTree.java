package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        while (label > 0) {
            list.add(0, label);
            int hi = Integer.highestOneBit(label) - 1;
            label >>= 1;
            int lo = Integer.highestOneBit(label);
            label = lo + hi - label;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new PathInZigzagLabelledBinaryTree().pathInZigZagTree(26));
    }

}
