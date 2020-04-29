package algorithms;

interface MountainArray {
    public int get(int index);

    public int length();
}

public class FindInMountainArray {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int lo = 0, hi = mountainArr.length() - 1;
        while (lo + 1 < hi) {
            int mid = lo + hi >> 1;
            int midVal = mountainArr.get(mid);
            if (midVal > mountainArr.get(mid - 1)) lo = mid;
            else hi = mid;
        }
        int peak = mountainArr.get(lo) > mountainArr.get(hi) ? lo : hi;
        int index = binarySearch(mountainArr, 0, peak, target, true);
        return index != -1 ? index : binarySearch(
                mountainArr, peak + 1, mountainArr.length() - 1, target, false);
    }

    private int binarySearch(MountainArray mountainArr, int lo, int hi,
            int target, boolean asc) {
        while (lo <= hi) {
            int mid = lo + hi >> 1;
            int midVal = mountainArr.get(mid);
            if (midVal == target) return mid;
            if (midVal < target && asc || midVal >= target && !asc) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        MountainArray mountainArr = new MountainArray() {
            private int[] array = { 1, 2, 3, 4, 5, 3, 1 };

            public int length() {
                return array.length;
            }

            public int get(int index) {
                return array[index];
            }
        };
        System.out.println(new FindInMountainArray().findInMountainArray(3, mountainArr));
    }

}
