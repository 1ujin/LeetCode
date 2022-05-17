package algorithms;

public class KthSmallestNumberInMultiplicationTable {

    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            int count = mid / n * n;
            for (int i = mid / n + 1; i <= m; ++i)
                count += mid / i;
            if (count >= k)
                hi = mid;
            else
                lo = mid + 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(new KthSmallestNumberInMultiplicationTable()
                .findKthNumber(3, 3, 5));
    }

}
