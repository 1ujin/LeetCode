package lcci;

public class Coin {
    
    public int waysToChange(int n) {
        int[] coins = new int[] {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins)
            for (int i = coin; i <= n; i++)
                // 等于上一轮 coin （没有此轮 coin 时）的当前情况加 i 减去此轮 coin （差 1 个 coin 就等于 i）的情况
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Coin().waysToChange(10));
    }

}
