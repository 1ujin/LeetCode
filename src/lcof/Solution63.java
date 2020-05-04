package lcof;

public class Solution63 {

    // method 1 dynamic programming
    public int maxProfit1(int[] prices) {
        if (prices.length < 2) return 0;
        int max = 0, low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            low = low < prices[i] ? low : prices[i];
            int profit = prices[i] - low;
            max = max > profit ? max : profit;
        }
        return max;
    }
    
    // method 2
    public int maxProfit2(int[] prices) {
        int low = Integer.MAX_VALUE, max = 0;
        for (int price : prices) {
            if (price < low) low = price;
            else {
                int profit = price - low;
                max = max > profit ? max : profit;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(new Solution63().maxProfit2(prices));
    }

}
