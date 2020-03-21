package lcci;

public class SearchRotateArray {
    
    public int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        if (right == -1) return -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[left] < arr[mid]) {
                if (arr[left] <= target && arr[mid] >= target) right = mid;
                else left = ++mid;
            } else if (arr[left] > arr[mid]) {
                if (arr[left] <= target || arr[mid] >= target) right = mid;
                else left = ++mid;
            } else {
                if (arr[mid] == target) return left;
                else left++;
            }
        }
        return arr[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchRotateArray().search(new int[] {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
    }

}
