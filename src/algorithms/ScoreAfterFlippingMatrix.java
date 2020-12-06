package algorithms;

public class ScoreAfterFlippingMatrix {

    // method 1
    public int matrixScore1(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++)
            if (A[i][0] == 0)
                for (int j = 0; j < n; j++)
                    A[i][j] ^= 1;
        for (int i = 1; i < n; i++) {
            int zeroCount = 0;
            for (int j = 0; j < m; j++)
                if (A[j][i] == 0)
                    zeroCount++;
            if (zeroCount > m >> 1)
                for (int j = 0; j < m; j++)
                    A[j][i] ^= 1;
        }
        int score = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                score += A[i][j] << n - j - 1;
        return score;
    }
    
    // method 2
    public int matrixScore2(int[][] A) {
        int m = A.length, n = A[0].length;
        int score = m * (1 << n - 1);
        for (int j = 1; j < n; j++) {
            int oneCount = 0;
            for (int i = 0; i < m; i++)
                oneCount += A[i][0] == A[i][j] ? 1 : 0;
            score += Math.max(oneCount, m - oneCount) * (1 << n - j - 1);
        }
        return score;
    }

    public static void main(String[] args) {
        int[][] A = { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } };
        System.out.println(new ScoreAfterFlippingMatrix().matrixScore2(A));
    }

}
