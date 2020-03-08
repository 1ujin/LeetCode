package algorithms;

public class BestTimeToBuyAndSellStock {
    
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int profit = 0, low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            low = low <= prices[i] ? low : prices[i];
            profit = profit >= prices[i] - low ? profit : prices[i] - low;
        }
        return profit;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int result = new BestTimeToBuyAndSellStock().maxProfit(new int[] {7, 1, 5, 3, 6, 4});
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
