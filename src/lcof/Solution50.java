package lcof;

import java.util.HashMap;
import java.util.Map;

public class Solution50 {
    
    // method 1
    public char firstUniqChar1(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Boolean> map = new HashMap<>();
        for (char c : cs)
            map.compute(c, (k, v) -> v == null);
        for (char c : cs)
            if (map.get(c))
                return c;
        return ' ';
    }
    
    // method 2 counting
    public char firstUniqChar2(String s) {
        int[] count = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs)
            count[c - 'a']++;
        for (char c : cs)
            if (count[c - 'a'] == 1)
                return c;
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Solution50().firstUniqChar2("abaccdeff"));
    }

}
