package lcof;

public class Solution44 {
    
    public int findNthDigit(int n) {
        if (n < 10) return n;
        double temp = 9;
        int i = 1;
        while (n > temp) {
            n -= temp;
            i++;
            temp = 9 * i * Math.pow(10, i - 1);
        }
        String s = String.valueOf((n - 1) / i + (int) Math.pow(10, i - 1));
        return s.charAt((n - 1) % i) - '0';
    }

    public static void main(String[] args) {
        System.out.println(new Solution44().findNthDigit(1000000000));
    }

}
