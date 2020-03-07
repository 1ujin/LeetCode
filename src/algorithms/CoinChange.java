package algorithms;

public class CoinChange {
    
    // method 1 dynamic programming bottom-up
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++)
            dp[i] = amount + 1;
        for (int coin : coins)
            for (int j = coin; j <= amount; j++)
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
    
    // method 2 dynamic programming top-down
    public int coinChange2(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange2(coins, amount, new int[amount]);
    }

    private int coinChange2(int[] coins, int amount, int[] count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (count[amount - 1] != 0) return count[amount - 1];
        int min = amount + 1;
        for (int coin : coins) {
            int res = coinChange2(coins, amount - coin, count);
            if (res >= 0 && res < min) min = res + 1;
        }
        count[amount - 1] = min == amount + 1 ? -1 : min;
        return count[amount - 1];
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int result = new CoinChange().coinChange2(new int[] {186, 419, 83, 408}, 6249);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
