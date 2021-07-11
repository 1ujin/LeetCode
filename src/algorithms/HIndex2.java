package algorithms;

public class HIndex2 {

    public int hIndex(int[] citations) {
        int len = citations.length, lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = lo + hi >>> 1;
            if (citations[mid] < len - mid)
                lo = mid + 1;
            else if (citations[mid] > len - mid)
                hi = mid - 1;
            else
                return len - mid;
        }
        return len - lo;
    }

    public static void main(String[] args) {
        int[] citations = { 0, 1, 3, 5, 6 };
        System.out.println(new HIndex2().hIndex(citations));
    }

}
