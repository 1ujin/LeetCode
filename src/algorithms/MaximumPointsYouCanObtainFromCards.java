package algorithms;

public class MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0, window = 0, len = cardPoints.length;
        for (int cardPoint : cardPoints)
            sum += cardPoint;
        for (int i = 0; i < len - k; i++)
            window += cardPoints[i];
        int min = window;
        for (int i = 0; i < k; i++)
            min = Math.min(min, window += cardPoints[len + i - k] - cardPoints[i]);
        return sum - min;
    }

    public static void main(String[] args) {
        int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(cardPoints, 3));
    }

}
