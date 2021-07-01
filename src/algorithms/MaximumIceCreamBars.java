package algorithms;

import java.util.Arrays;

public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            if ((coins -= cost) >= 0)
                count++;
            else
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] costs = { 1, 3, 2, 4, 1 };
        System.out.println(new MaximumIceCreamBars().maxIceCream(costs, 7));
    }

}
