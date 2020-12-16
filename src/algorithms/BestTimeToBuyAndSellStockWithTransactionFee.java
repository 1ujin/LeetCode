package algorithms;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    
    // method 1 dynamic programming
    public int maxProfit1(int[] prices, int fee) {
        int in = -prices[0], out = 0;
        for (int i = 1; i < prices.length; i++) {
            in = Math.max(in, out - prices[i]);
            out = Math.max(out, in + prices[i] - fee);
        }
        return out;
    }
    
    // method 2 dynamic programming fastest
    public int maxProfit(int[] prices, int fee) {
        int in = -prices[0], out = 0;
        for (int i = 1; i < prices.length; i++) {
            if (in > out - prices[i])
                out = Math.max(out, in + prices[i] - fee);
            else in = out - prices[i];
        }
        return out;
    }
    
    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee()
                .maxProfit(prices, 2));
    }

}
