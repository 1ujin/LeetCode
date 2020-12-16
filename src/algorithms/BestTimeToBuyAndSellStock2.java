package algorithms;

public class BestTimeToBuyAndSellStock2 {

    // method 1 greedy algorithm fastest
    public int maxProfit1(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1])
                profit += prices[i] - prices[i - 1];
        return profit;
    }
    
    // method 2 dynamic programming
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][0]);
    }
    
    // method 3 dynamic programming
    public int maxProfit3(int[] prices) {
        int in = -prices[0], out = 0;
        for (int i = 1; i < prices.length; i++) {
             in = Math.max(in, out - prices[i]);
             out = Math.max(out, in + prices[i]);
        }
        return out;
    }
    
    // method 4 dynamic programming fastest
    public int maxProfit(int[] prices) {
        int in = -prices[0], out = 0;
        for (int i = 1; i < prices.length; i++) {
            if (in > out - prices[i])
                out = Math.max(out, in + prices[i]);
            else in = out - prices[i];
        }
        return out;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(new BestTimeToBuyAndSellStock2().maxProfit1(prices));
    }

}
