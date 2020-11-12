package algorithms;

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {
    
    public int maxCoins(int[] piles) {
        int len = piles.length, begin = len / 3, sum = 0;
        Arrays.sort(piles);
        for (int i = begin; i < len; i += 2)
            sum += piles[i];
        return sum;
    }

    public static void main(String[] args) {
        int[] piles = { 2, 4, 1, 2, 7, 8 };
        System.out.println(new MaximumNumberOfCoinsYouCanGet().maxCoins(piles));
    }

}
