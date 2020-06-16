package algorithms;

public class BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {
        int score = 0, tmp = 0;
        for (int i = 0; i < A.length - 1; i++) {
            tmp = Math.max(tmp, A[i] + i);
            score = Math.max(score, tmp + A[i + 1] - i - 1);
        }
        return score;
    }

    public static void main(String[] args) {
        int[] A = { 8, 1, 5, 2, 6 };
        System.out.println(new BestSightseeingPair().maxScoreSightseeingPair(A));
    }

}
