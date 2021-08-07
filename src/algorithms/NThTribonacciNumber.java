package algorithms;

public class NThTribonacciNumber {
    
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        int a = 0, b = 1, c = 1;
        while (n-- > 2) {
            int sum = a + b + c;
            a = b;
            b = c;
            c = sum;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new NThTribonacciNumber().tribonacci(25));
    }

}
