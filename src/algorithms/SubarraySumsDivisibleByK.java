package algorithms;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

    // method 1
    public int subarraysDivByK1(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int i : A) {
            sum += i;
            int mod = (sum % K + K) % K;
            // 当 mod 再次出现时，说明 sum 增加了可以被 K 整除的数的和
            // count += map.merge(mod, 1, (oldVal, newVal) -> oldVal + newVal) - 1;
            int val = map.getOrDefault(mod, 0);
            count += val;
            map.put(mod, val + 1);
        }
        return count;
    }
    
    // method 2 dynamic programming
    public int subarraysDivByK2(int[] A, int K) {
        int[] dp = new int[K];
        dp[0] = 1;
        int sum = 0, count = 0;
        for (int i : A) {
            sum = ((sum + i) % K + K) % K;
            count += dp[sum]++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = { 4, 5, 0, -2, -3, 1 };
        System.out.println(new SubarraySumsDivisibleByK().subarraysDivByK2(A, 5));
    }

}
