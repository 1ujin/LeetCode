package algorithms;

import java.util.ArrayList;
import java.util.List;

public class CountNodesWithTheHighestScore {

    private long maxScore;
    private int count, len;
    private List<Integer>[] tree;

    @SuppressWarnings("unchecked")
    public int countHighestScoreNodes(int[] parents) {
        len = parents.length;
        tree = new List[len];
        for (int i = 0; i < len; i++) {
            int parent = parents[i];
            if (parent != -1) {
                if (tree[parent] == null)
                    tree[parent] = new ArrayList<>();
                tree[parent].add(i);
            }
        }
        dfs(0);
        return count;
    }

    private int dfs(int root) {
        long score = 1;
        int remindSize = len - 1;
        if (tree[root] != null) {
            for (int node : tree[root]) {
                int nodeSize = dfs(node);
                score *= nodeSize;
                remindSize -= nodeSize;
            }
        }
        if (root != 0)
            score *= remindSize;
        if (score > maxScore) {
            maxScore = score;
            count = 0;
        }
        if (score == maxScore)
            count++;
        return len - remindSize;
    }

    public static void main(String[] args) {
        int[] parents = { -1, 2, 0, 2, 0 };
        System.out.println(new CountNodesWithTheHighestScore()
                .countHighestScoreNodes(parents));
    }

}
