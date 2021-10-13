package lcof;

public class SolutionII069 {

    public int peakIndexInMountainArray(int[] arr) {
        int lo = 1, hi = arr.length - 2, peak = 0;
        while (lo <= hi) {
            int mid = lo + hi >> 1;
            if (arr[mid] > arr[mid + 1]) {
                peak = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return peak;
    }

    public static void main(String[] args) {
        int[] arr = { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 };
        System.out.println(new SolutionII069().peakIndexInMountainArray(arr));
    }

}
