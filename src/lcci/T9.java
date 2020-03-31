package lcci;

import java.util.ArrayList;
import java.util.List;

public class T9 {
    
    public List<String> getValidT9Words(String num, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            int i = 0;
            for (; i < word.length(); i++) {
                char ch = word.charAt(i), n = num.charAt(i);
                if (ch < 'p' && (ch - 'a') / 3 + '2' != n) break;
                else if (ch > 'o' && ch < 't' && n != '7') break;
                else if (ch > 's' && ch < 'w' && n != '8') break;
                else if (ch > 'v' && n != '9') break;
            }
            if (i == word.length()) result.add(word);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new T9().
                getValidT9Words("8733",new String[] {"tree", "used"}));
    }

}
