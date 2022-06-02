package algorithms;

public class ConsecutiveNumbersSum {

    public int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int i = 1, sum = 0; sum < n; i++) {
            sum += i;
            if (n >= sum && (n - sum) % i == 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new ConsecutiveNumbersSum().consecutiveNumbersSum(15));
    }

}
