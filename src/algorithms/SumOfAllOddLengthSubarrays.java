package algorithms;

public class SumOfAllOddLengthSubarrays {

    // method 1 prefix sum
    public int sumOddLengthSubarrays1(int[] arr) {
        int len = arr.length, maxOdd = (len >> 1 << 1) + 1, sum = 0;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++)
            preSum[i + 1] = arr[i] + preSum[i];
        for (int i = 1; i <= maxOdd; i += 2)
            for (int j = 0; j + i <= len; j++)
                sum += preSum[j + i] - preSum[j];
        return sum;
    }

    // method 2 fastest
    public int sumOddLengthSubarrays2(int[] arr) {
        int len = arr.length, sum = 0;
        for (int i = 0; i < len; i++) {
            int leftOdd = i + 1 >> 1;
            int leftEven = (i >> 1) + 1;
            int rightOdd = len - i >> 1;
            int rightEven = (len - 1 - i >> 1) + 1;
            sum += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 5, 3 };
        System.out.println(new SumOfAllOddLengthSubarrays().sumOddLengthSubarrays2(arr));
    }

}
