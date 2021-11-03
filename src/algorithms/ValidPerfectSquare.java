package algorithms;

public class ValidPerfectSquare {

    // method 1 slowest
    public boolean isPerfectSquare1(int num) {
        long i = 1;
        while (i * i < num)
            i++;
        return i * i == num;
    }

    // method 2 binary-search fastest
    public boolean isPerfectSquare2(int num) {
        long lo = 0l, hi = num;
        while (lo <= hi) {
            long mid = lo + hi >> 1, square = mid * mid;
            if (square < num)
                lo = mid + 1;
            else if (square > num)
                hi = mid - 1;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare2(-1 >>> 1));
    }

}
