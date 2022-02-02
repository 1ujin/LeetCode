package algorithms;

public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {
    
    public int findMinFibonacciNumbers(int k) {
        // 1 <= k <= 1000000000, 最多只有43个不同的数
        int[] nums = new int[43];
        int a = 1, b = 1;
        nums[0] = 1;
        int i = 0;
        while (a + b <= k) {
            int c = a + b;
            nums[++i] = c;
            a = b;
            b = c;
        }
        int count = 0;
        for (; i >= 0 && k > 0; i--) {
            int num = nums[i];
            if (k >= num) {
                k -= num;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK().findMinFibonacciNumbers(1000000000));
    }

}
