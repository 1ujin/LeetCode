package algorithms;

public class FrogJump {

    public boolean canCross(int[] stones) {
        int len = stones.length;
        boolean[][] dp = new boolean[len][len];
        dp[0][0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int dist = stones[j] - stones[i];
                if (dist > i + 1)
                    break;
                dp[j][dist] = dp[i][dist - 1] || dp[i][dist] || dp[i][dist + 1];
                if (j == len - 1 && dp[j][dist])
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
        System.out.println(new FrogJump().canCross(stones));
    }

}
