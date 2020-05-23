package algorithms;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    
    // method 1 slowest
    public String minWindow1(String s, String t) {
        int left = 0, right = -1, sLen = s.length(), tLen = t.length(), minLeft = -1, min = 0;
        Map<Character, Integer> tMap = new HashMap<>(), sMap = new HashMap<>();
        for (int i = 0; i < tLen; i++)
            tMap.merge(t.charAt(i), 1, (oldVal, newVal) -> oldVal + newVal);
        char[] cs = s.toCharArray();
        outer: while (++right < sLen) {
            if (tMap.containsKey(cs[right]))
                sMap.merge(cs[right], 1, (oldVal, newVal) -> oldVal + newVal);
            for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
                char key = entry.getKey();
                int tValue = entry.getValue(), sValue = sMap.getOrDefault(key, 0);
                if (tValue > sValue)
                    continue outer;
            }
            if (min == 0 || min > right - left + 1) {
                min = right - left + 1;
                minLeft = left;
            }
            inner: while (left++ <= right) {
                if (tMap.containsKey(cs[left - 1]))
                    sMap.merge(cs[left - 1], -1, (oldVal, newVal) -> oldVal + newVal);
                else continue inner;
                for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
                    char key = entry.getKey();
                    int tValue = entry.getValue(), sValue = sMap.getOrDefault(key, 0);
                    if (tValue > sValue) {
                        if (min > right - left + 2) {
                            min = right - left + 2;
                            minLeft = left - 1;
                        }
                        continue outer;
                    }
                }
            }
        }
        return minLeft == -1 ? "" : s.substring(minLeft, minLeft + min);
    }
    
    // method 2 fastest
    public String minWindow2(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) return "";
        int[] tCount = new int[128];
        for (char c : t.toCharArray())
            tCount[c]++;
        char[] cs = s.toCharArray();
        int min = sLen + 1, minLeft = 0, left = 0, right = 0;
        while (right < sLen) {
            char tail = cs[right++];
            // 最右侧新字符的数量大于 0 时，说明此字符存在于 t 中，所需字符数减 1
            if (tCount[tail]-- > 0)
                tLen--;
            // 当 tLen 等于 0 时，子串拥有 t 中全部的字符，循环去除最左侧字符
            while (tLen == 0) {
                if (min > right - left) {
                    min = right - left;
                    minLeft = left;
                }
                char head = cs[left++];
                // 最左侧新字符的数量大于 0 时，说明此字符存在于 t 中，所需字符数增 1
                if (++tCount[head] > 0)
                    tLen++;
            }
        }
        return min > sLen ? "" : s.substring(minLeft, minLeft + min);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow2("ADOBECODEBANC", "ABC"));
    }

}
