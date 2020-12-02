package algorithms;

import java.util.Arrays;

public class CountPrimes {
    
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        for (int i = 2; i * i < n; i++) {
            if (!isPrimes[i]) continue;
            for (int j = i * i; j < n; j += i)
                isPrimes[j] = false;
        }
        int count = 0;
        for (boolean isPrime : isPrimes)
            count += isPrime ? 1 : 0;
        return count - 2;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(12));
    }

}
