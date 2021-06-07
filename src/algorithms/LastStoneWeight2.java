package algorithms;

public class LastStoneWeight2 {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones)
            sum += stone;
        int len = sum >> 1;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int stone : stones)
            for (int i = len; i >= stone; i--)
                dp[i] = dp[i] | dp[i - stone];
        for (int i = len; i >= 0; i--)
            if (dp[i])
                return sum - (i << 1);
        return len;
    }

    public static void main(String[] args) {
        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(new LastStoneWeight2().lastStoneWeightII(stones));
    }

}
