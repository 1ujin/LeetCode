package algorithms;

public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;
        int sum = 1;
        for (int divisor = 2; divisor * divisor <= num; divisor++) {
            if (num % divisor != 0)
                continue;
            if (num != divisor * divisor)
                sum += divisor;
            sum += num / divisor;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectNumber().checkPerfectNumber(8128));
    }

}
