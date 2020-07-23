package algorithms;

public class DivisorGame {
    
    // method 1 fastest
    public boolean divisorGame1(int N) {
        return (N & 1) == 0;
    }

    // method 2 dynamic programming
    private boolean divisorGame2(int N) {
        boolean[] dp = new boolean[N + 5];
        dp[2] = true;
        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if ((i % j) == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
    
    public static void main(String[] args) {
        System.out.println(new DivisorGame().divisorGame2(10));
    }

}
