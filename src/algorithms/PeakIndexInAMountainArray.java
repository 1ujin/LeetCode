package algorithms;

public class PeakIndexInAMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1])
                lo = mid;
            else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1])
                hi = mid;
            else
                return mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] arr = { 24, 69, 100, 99, 79, 78, 67, 36, 26, 19 };
        System.out.println(new PeakIndexInAMountainArray().peakIndexInMountainArray(arr));
    }

}
