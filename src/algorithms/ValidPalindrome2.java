package algorithms;

public class ValidPalindrome2 {
    
    public boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();
        int lo = 0, hi = cs.length - 1;
        while (lo < hi) {
            if (cs[lo] == cs[hi]) {
                lo++;
                hi--;
            } else {
                int lo1 = lo + 1, hi1 = hi;
                while (lo1 < hi1 && cs[lo1] == cs[hi1]) {
                    lo1++;
                    hi1--;
                }
                if (lo1 >= hi1) return true;
                int lo2 = lo, hi2 = hi - 1;
                while (lo2 < hi2 && cs[lo2] == cs[hi2]) {
                    lo2++;
                    hi2--;
                }
                if (lo2 >= hi2) return true;
                if (lo1 < hi1 && lo2 < hi2) return false;
            }
        }
        return lo >= hi;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome2().validPalindrome("ebcbbececabbacecbbcbe"));
    }

}
