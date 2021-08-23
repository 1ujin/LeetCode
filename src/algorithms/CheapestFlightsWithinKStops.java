package algorithms;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int cheapest = Integer.MAX_VALUE >> 1;
        int[][] dp = new int[k + 2][n];
        for (int[] row : dp)
            Arrays.fill(row, cheapest);
        dp[0][src] = 0;
        for (int count = 1; count < k + 2; count++) {
            for (int[] flight : flights) {
                int last = flight[0], current = flight[1], price = flight[2];
                dp[count][current] = Math.min(dp[count][current], dp[count - 1][last] + price);
            }
        }
        for (int i = 1; i < k + 2; i++)
            cheapest = dp[i][dst] < cheapest ? dp[i][dst] : cheapest;
        return cheapest == Integer.MAX_VALUE >> 1 ? -1 : cheapest;
    }

    public static void main(String[] args) {
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(3, flights, 0, 2, 1));
    }

}
