package algorithms;

public class FibonacciNumber {
    
    // method 1 recursion
    public int fib1(int N) {
        if (N < 2) return N;
        return fib1(N - 1) + fib1(N - 2);
    }
    
    // method 2 dynamic programming fastest
    public int fib2(int N) {
        if (N < 2) return N;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= N; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().fib2(10));
    }

}
