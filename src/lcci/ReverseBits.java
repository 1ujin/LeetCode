package lcci;

public class ReverseBits {
    
    public int reverseBits(int num) {
        if (num == Integer.MAX_VALUE) return 32;
        if (num == Integer.MIN_VALUE) return 2;
        int maxOneLen = 1, preOneLen = 0, tmpOneLen = 0;
        int sign = num > -Integer.MAX_VALUE/2 - 2 && num < 0 ? 1 : 0;
        num = num < 0 ? ~num | Integer.MIN_VALUE : ~num;
        while (num != -1) {
            tmpOneLen = Integer.numberOfTrailingZeros(num) + 1;
            maxOneLen = maxOneLen > preOneLen + tmpOneLen ? maxOneLen : preOneLen + tmpOneLen;
            num >>= tmpOneLen;
            preOneLen = tmpOneLen - 1;
        }
        return maxOneLen + sign;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(-2147483648));
    }

}
