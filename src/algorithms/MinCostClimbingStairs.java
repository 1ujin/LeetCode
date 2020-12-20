package algorithms;

public class MinCostClimbingStairs {
    
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        for (int i = 2; i < len; i++)
            cost[i] += Math.min(cost[i - 2], cost[i - 1]);
        return Math.min(cost[len - 2], cost[len - 1]);
    }

    public static void main(String[] args) {
        int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));
    }

}
