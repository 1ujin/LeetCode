package lcof;

public class Solution11 {

    public int minArray(int[] numbers) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (numbers[mid] > numbers[hi])
                lo = mid + 1;
            else if (numbers[mid] < numbers[hi])
                hi = mid;
            else
                hi--;
        }
        return numbers[lo];
    }

    public static void main(String[] args) {
        int[] numbers = { 3, 4, 5, 1, 2 };
        System.out.println(new Solution11().minArray(numbers));
    }

}
