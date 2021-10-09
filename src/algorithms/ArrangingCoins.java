package algorithms;

public class ArrangingCoins {

    public int arrangeCoins(int n) {
        long lo = 0, hi = n;
        while (lo <= hi) {
            long mid = lo + hi >> 1;
            long coins = (1 + mid) * mid >> 1;
            if (coins > n)
                hi = mid - 1;
            else if (coins < n)
                lo = mid + 1;
            else
                return (int) mid;
        }
        return (int) hi;
    }

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(1804289383));
    }

}
