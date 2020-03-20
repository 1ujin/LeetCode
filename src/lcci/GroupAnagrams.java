package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            // key 存在则直接返回 value 否则声明一个新的 <key, value> 并返回 value
            map.computeIfAbsent(String.valueOf(chars), k -> new ArrayList<>()).add(string);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<List<String>> result = new GroupAnagrams().groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
