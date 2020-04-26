package lcof;

public class Solution43 {
    
    public int countDigitOne(int n) {
        int count = 0, tail = 0, a = 0, b = 1;
        while (n > 0) {
            if (n % 10 == 1) count += tail + 1;
            else if (n % 10 > 1) count += b;
            count += n % 10 * a;
            tail += n % 10 * b;
            a = a * 10 + b;
            b *= 10;
            n /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution43().countDigitOne(13));
    }

}
