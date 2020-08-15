package algorithms;

public class RemoveBoxes {
    
    int[] boxes;
    int[][][] dp;

    public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        this.boxes = boxes;
        dp = new int[len][len][len];
        return recur(0, len - 1, 0);
    }

    private int recur(int begin, int end, int k) {
        if (begin > end) return 0;
        if (dp[begin][end][k] != 0) return dp[begin][end][k];
        while (begin < end && boxes[end] == boxes[end - 1]) {
            end--;
            k++;
        }
        dp[begin][end][k] = recur(begin, end - 1, 0) + (k + 1) * (k + 1);
        for (int i = begin; i < end; i++)
            if (boxes[i] == boxes[end])
                dp[begin][end][k] = Math.max(dp[begin][end][k],
                        recur(begin, i, k + 1) + recur(i + 1, end - 1, 0));
        return dp[begin][end][k];
    }

    public static void main(String[] args) {
        int[] boxes = { 1, 3, 2, 2, 2, 3, 4, 3, 1 };
        System.out.println(new RemoveBoxes().removeBoxes(boxes));
    }

}
