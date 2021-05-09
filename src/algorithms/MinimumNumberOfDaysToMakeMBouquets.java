package algorithms;

public class MinimumNumberOfDaysToMakeMBouquets {

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k)
            return -1;
        int lo = -1 >>> 1, hi = -1;
        for (int day : bloomDay) {
            lo = Math.min(lo, day);
            hi = Math.max(hi, day);
        }
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (canMake(bloomDay, m, k, mid))
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        for (int i = 0, flowers = 0; i < bloomDay.length && bouquets < m; i++) {
            if (bloomDay[i] > day) {
                flowers = 0;
                continue;
            }
            if (++flowers == k) {
                bouquets++;
                flowers = 0;
            }
        }
        return bouquets >= m;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 7, 7, 7, 7, 12, 7, 7 };
        System.out.println(new MinimumNumberOfDaysToMakeMBouquets().minDays(bloomDay, 2, 3));
    }

}
