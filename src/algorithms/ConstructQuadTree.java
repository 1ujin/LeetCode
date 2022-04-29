package algorithms;

public class ConstructQuadTree {

    @SuppressWarnings("unused")
    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight,
                Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };

    private int[][] dp;

    public Node construct(int[][] grid) {
        int n = grid.length;
        dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j]
                        + grid[i][j];
        return dfs(0, 0, n, n);
    }

    private Node dfs(int begin1, int begin2, int end1, int end2) {
        int sum = dp[end1][end2] - dp[end1][begin2] - dp[begin1][end2]
                + dp[begin1][begin2];
        if (sum == 0 || sum == (end1 - begin1) * (end2 - begin2))
            return new Node(sum != 0, true);
        int mid1 = begin1 + end1 >> 1, mid2 = begin2 + end2 >> 1;
        return new Node(true, false,
                dfs(begin1, begin2, mid1, mid2),
                dfs(begin1, mid2, mid1, end2),
                dfs(mid1, begin2, end1, mid2),
                dfs(mid1, mid2, end1, end2));
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 },
                { 0, 0, 1, 1 } };
        new ConstructQuadTree().construct(grid);
    }

}
