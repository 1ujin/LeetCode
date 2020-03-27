package lcci;

public class Maximum {
    
    public int maximum(int a, int b) {
        int k = b - a >>> 31;
        int aSign = a >>> 31, bSign = b >>> 31;
        int diff = aSign ^ bSign;
        k = k & (diff ^ 1) | bSign & diff;
        return a * k + b * (k ^ 1);
    }

    public static void main(String[] args) {
        System.out.println(new Maximum().maximum(10, Integer.MIN_VALUE));
    }

}
