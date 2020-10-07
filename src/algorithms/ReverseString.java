package algorithms;

import java.util.Arrays;

public class ReverseString {

    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = len >> 1; i > 0; i--) {
            char t = s[i - 1];
            s[i - 1] = s[len - i];
            s[len - i] = t;
        }
    }

    public static void main(String[] args) {
        char[] s = "hello".toCharArray();
        new ReverseString().reverseString(s);
        System.out.println(Arrays.toString(s));
    }

}
