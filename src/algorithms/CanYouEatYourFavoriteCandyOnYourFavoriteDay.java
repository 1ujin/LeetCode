package algorithms;

import java.util.Arrays;

public class CanYouEatYourFavoriteCandyOnYourFavoriteDay {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++)
            sum[i] = sum[i - 1] + candiesCount[i];
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int favoriteType = query[0], favoriteDay = query[1], dailyCap = query[2];
            long x1 = favoriteDay + 1;
            long y1 = (long) (favoriteDay + 1) * dailyCap;
            long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1;
            long y2 = sum[favoriteType];
            answer[i] = !(x1 > y2 || y1 < x2);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] candiesCount = { 5, 2, 6, 4, 1 };
        int[][] queries = { { 3, 1, 2 }, { 4, 10, 3 }, { 3, 10, 100 }, { 4, 100, 30 }, { 1, 3, 1 } };
        System.out.println(Arrays.toString(new CanYouEatYourFavoriteCandyOnYourFavoriteDay().canEat(candiesCount, queries)));
    }

}
