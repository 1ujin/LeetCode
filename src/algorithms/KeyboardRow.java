package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardRow {

    public String[] findWords(String[] words) {
        char[] keys = "12210111011122000010020202".toCharArray();
        List<String> list = new ArrayList<>();
        out: for (String word : words) {
            char last = ' ';
            for (char c : word.toCharArray()) {
                int current = c > 'Z' ? c - 'a' : c - 'A';
                if (last != ' ' && last != keys[current])
                    continue out;
                else
                    last = keys[current];
            }
            list.add(word);
        }
        String[] strs = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            strs[i] = list.get(i);
        return strs;
    }

    public static void main(String[] args) {
        String[] words = { "Hello", "Alaska", "Dad", "Peace" };
        System.out.println(Arrays.toString(new KeyboardRow().findWords(words)));
    }

}
