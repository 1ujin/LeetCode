package lcci;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
    
    // method 1 bitmap fastest
    public boolean canPermutePalindrome1(String s) {
        long highBmp = 0, lowBmp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 64)
                highBmp ^= 1L << s.charAt(i) - 64;
            else
                lowBmp ^= 1L << s.charAt(i);
        }
        return Long.bitCount(highBmp) + Long.bitCount(lowBmp) <= 1;
    }
    
    // method 2 hash table
    public boolean canPermutePalindrome2(String s) {
        Set<Character> set = new HashSet<>();
        for (Character c : s.toCharArray())
            if (!set.add(c))
                set.remove(c);
        return set.size() <= 1;
    }

    public static void main(String[] args) {
        PalindromePermutation solution = new PalindromePermutation();
        long startTime = System.nanoTime();
        boolean result = solution.canPermutePalindrome1("AaBb//a");
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
