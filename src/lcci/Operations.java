package lcci;

public class Operations {

    public Operations() {}
    
    public int minus(int a, int b) {
        return a + ~b + 1;
    }
    
    public int multiply(int a, int b) {
        int c = 0;
        for (int i = 0; i < 32; i++)
            if ((b & (1 << i)) != 0) 
                c += a << i;
        return c;
    }
    
    public int divide(int a, int b) {
        int c = 0;
        int aSign = (a & (1 << 31)) != 0 ? -1 : 1;
        int bSign = (b & (1 << 31)) != 0 ? -1 : 1;
        a = multiply(aSign, a);
        b = multiply(bSign, b);
        // time limit exceeded
        // int overflow = a == Integer.MIN_VALUE ? 1 : 0;
        // a = a == Integer.MIN_VALUE ? Integer.MAX_VALUE : a;
        // for (; a >= b - overflow; c++) a = minus(a, b);
        int i = 31, j = 31;
        for (; i > -1; i--)
            if ((a & (1 << i)) != 0)
                break;
        for (; j > -1; j--)
            if ((b & (1 << j)) != 0)
                break;
        if (i < j) return 0;
        for (int k = i - j; k > -1; k--) {
            if (a >= b << k) {
                a = minus(a, b << k);
                c += 1 << k;
            }
        }
        return multiply(multiply(aSign, bSign), c);
    }
    
    public static void main(String[] args) {
        Operations operations = new Operations();
        System.out.println(operations.divide(Integer.MIN_VALUE, 1));
    }
    
}
