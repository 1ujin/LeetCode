package algorithms;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    
    // method 1 hash
    public int numJewelsInStones1(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray())
            set.add(c);
        int count = 0;
        for (char c : S.toCharArray())
            if (set.contains(c))
                count++;
        return count;
    }
    
    // method 2 bitmap
    public int numJewelsInStones2(String J, String S) {
        int high = 0, low = 0, count = 0;
        for (char c : J.toCharArray()) {
            if (c < 'a') high |= 1 << c - 'A';
            else low |= 1 << c - 'a';
        }
        for (char c : S.toCharArray()) {
            if (c < 'a') count += high >> c - 'A' & 1;
            else count += low >> c - 'a' & 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new JewelsAndStones().numJewelsInStones2("aA", "aAAbbbb"));
    }

}
