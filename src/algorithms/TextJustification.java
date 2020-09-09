package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>(), temp = new ArrayList<>();
        int count = 0, len = 0;
        for (int i = 0; i < words.length; i++) {
            if (len + count + words[i].length() <= maxWidth) {
                count++;
                len += words[i].length();
                temp.add(words[i]);
                // 到达末尾
                if (i == words.length - 1) {
                    if (maxWidth - len - count + 1 > 0) {
                        char[] cs = new char[maxWidth - len - count];
                        Arrays.fill(cs, ' ');
                        temp.add(new String(cs));
                    }
                    list.add(makeRow(temp));
                }
            } else {
                // 插入空格字符串
                int spaceCount, spaceStrLen, leftCount;
                if (count == 1) {
                    leftCount = 0;
                    spaceStrLen = maxWidth - len - 1;
                } else {
                    spaceCount = maxWidth - len - --count * 2;
                    spaceStrLen = spaceCount < 0 ? -1 : spaceCount / count;
                    leftCount = Math.floorMod(spaceCount, count);
                    count = spaceCount < 0 ? leftCount : count;
                }
                for (int j = 0; j < count && len != maxWidth; j++) {
                    char[] cs = new char[spaceStrLen + (j < leftCount ? 1 : 0)];
                    Arrays.fill(cs, ' ');
                    temp.add(j * 2 + 1, new String(cs));
                }
                list.add(makeRow(temp));
                count = 0;
                len = 0;
                i--;
            }
        }
        return list;
    }

    // 生成一行
    private String makeRow(List<String> words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(' ');
            sb.append(word);
        }
        sb.deleteCharAt(0);
        words.clear();
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
        for (String string : new TextJustification().fullJustify(words, 16))
            System.out.println(string);
    }

}
