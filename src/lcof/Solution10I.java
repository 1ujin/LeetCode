package lcof;

public class Solution10I {
    
    public int fib(int n) {
        int a = 0, b = 1, sum = 0;
        while (n-- > 0) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Solution10I().fib(5));
    }

}
