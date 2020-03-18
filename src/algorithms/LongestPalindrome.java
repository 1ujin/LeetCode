package algorithms;

public class LongestPalindrome {
    
    public int longestPalindrome(String s) {
        int upBmp = 0, lowBmp = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c < 'a') upBmp ^= 1 << c - 'A';
            else lowBmp ^= 1 << c - 'a';
        }
        int odd = Integer.bitCount(upBmp) + Integer.bitCount(lowBmp);
        return len - (odd == 0 ? 0 : odd - 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
    }

}
