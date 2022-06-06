package algorithms;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 1;
        for (int pile : piles)
            hi = Math.max(hi, pile);
        int k = hi;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            int count = 0;
            for (int pile : piles)
                count += (pile + mid - 1) / mid;
            if (count <= h) {
                k = mid;
                hi = mid;
            } else
                lo = mid + 1;
        }
        return k;
    }

    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        System.out.println(new KokoEatingBananas().minEatingSpeed(piles, 8));
    }

}
