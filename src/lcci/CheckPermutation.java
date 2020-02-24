package lcci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    
    // method 1 fastest
    public boolean checkPermutation1(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return String.valueOf(c1).equals(String.valueOf(c2));
    }
    
    // method 2
    public boolean checkPermutation2(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (!map1.containsKey(c)) map1.put(c, 1);
            else map1.put(c, map1.get(c) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!map2.containsKey(c)) map2.put(c, 1);
            else map2.put(c, map2.get(c) + 1);
        }
        return map1.equals(map2);
    }

    public static void main(String[] args) {
        CheckPermutation solution = new CheckPermutation();
        long startTime = System.nanoTime();
        boolean result = solution.checkPermutation1("abc", "bca");
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
