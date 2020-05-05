package algorithms;

public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int len = days[days.length - 1];
        int[] dp = new int[len + 1], passes = { 1, 7, 30 };
        for (int day : days)
            dp[day] = Integer.MAX_VALUE;
        for (int i = days[0]; i <= len; i++) {
            if (dp[i] == 0) {
                dp[i] = dp[i - 1];
                continue;
            }
            for (int j = 0; j < costs.length; j++) {
                int pass = passes[j], cost = costs[j];
                int tmp = i > pass ? dp[i - pass] + cost : cost;
                dp[i] = dp[i] < tmp ? dp[i] : tmp;
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int[] days = { 1, 4, 6, 7, 8, 20 };
        int[] costs = { 2, 7, 15 };
        System.out.println(new MinimumCostForTickets().mincostTickets(days, costs));
    }

}
