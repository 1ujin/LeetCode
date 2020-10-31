package lcp;

class UIBDOe {
    
    public int minimumOperations(String leaves) {
        char[] cs = leaves.toCharArray();
        int len = cs.length;
        int[][] dp = new int[len][3];
        dp[0][0] = cs[0] == 'y' ? 1 : 0;
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            int isYellow = cs[i] == 'y' ? 1 : 0;
            dp[i][0] = dp[i - 1][0] + isYellow;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (isYellow ^ 1);
            if (i >= 2)
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + isYellow;
        }
        return dp[len - 1][2];
    }
    
}

public class LCP19 {

    public static void main(String[] args) {
        System.out.println(new UIBDOe().minimumOperations("rrryyyrryyyrr"));
    }

}
