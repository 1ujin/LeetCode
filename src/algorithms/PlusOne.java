package algorithms;

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0 && carry > 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        if (carry != 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = { 9, 9, 9 };
        System.out.println(Arrays.toString(new PlusOne().plusOne(digits)));
    }

}
