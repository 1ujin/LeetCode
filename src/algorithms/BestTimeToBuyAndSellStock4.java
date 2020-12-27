package algorithms;

public class BestTimeToBuyAndSellStock4 {
    
    public int maxProfit(int k, int[] prices) {
        if (k < 1 || prices == null || prices.length < 2) return 0;
        int[] buy = new int[k], sell = new int[k];
        for (int i = 0; i < k; i++)
            buy[i] = Integer.MIN_VALUE;
        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                buy[i] = Math.max(buy[i], i == 0 ? -price : sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k - 1];
    }

    public static void main(String[] args) {
        int[] prices = { 3, 2, 6, 5, 0, 3 };
        System.out.println(new BestTimeToBuyAndSellStock4().maxProfit(2, prices));
    }

}
