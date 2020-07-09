package algorithms;

public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int a = -prices[0], b = 0, c = 0;
        for (int i = 1; i < len; i++) {
            int t1 = Math.max(a, c - prices[i]);
            int t2 = a + prices[i];
            int t3 = Math.max(b, c);
            a = t1; b = t2; c= t3;
        }
        return Math.max(b, c);
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 0, 2 };
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(prices));
    }

}
