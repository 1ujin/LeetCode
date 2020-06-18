package algorithms;

public class ValidPalindrome {
    
    public boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length, lo = 0, hi = len - 1;
        while (lo < hi) {
            while (lo < len - 1 && (cs[lo] < '0' || cs[lo] > '9')
                    && (cs[lo] < 'A' || cs[lo] > 'Z')
                    && (cs[lo] < 'a' || cs[lo] > 'z'))
                ++lo;
            while (hi > 0 && (cs[hi] < '0' || cs[hi] > '9')
                    && (cs[hi] < 'A' || cs[hi] > 'Z')
                    && (cs[hi] < 'a' || cs[hi] > 'z'))
                --hi;
            if (lo <= hi && cs[lo] != cs[hi] && (Math.max(cs[lo], cs[hi]) >= 'A'
                    && Math.min(cs[lo], cs[hi]) <= '9'
                    || Math.abs(cs[lo] - cs[hi]) != 32))
                return false;
            ++lo;
            --hi;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }

}
