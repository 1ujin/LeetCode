package lcci;

public class NumberOf2sInRange {
    
    public int numberOf2sInRange(int n) {
        int result = 0, tail = 0, a = 0, b = 1;
        while (n > 0) {
            if (n % 10 == 2) result += tail + 1;
            else if (n % 10 > 2) result += b;
            result += n % 10 * a;
            tail += n % 10 * b;
            a = a * 10 + b;
            b *= 10;
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf2sInRange().numberOf2sInRange(12345));
    }

}
