package algorithms;

import java.util.Arrays;

public class StringCompression {

    public int compress(char[] chars) {
        int i = 0, j = 1, k = 0, count = 1, len = chars.length;
        if (len < 2)
            return 1;
        while (j < len) {
            if (chars[i] != chars[j]) {
                chars[k++] = chars[i];
                k = appendCount(chars, count, k);
                count = 0;
            }
            count++;
            i++;
            j++;
        }
        chars[k++] = chars[i];
        if (chars[i] == chars[i - 1])
            k = appendCount(chars, count, k);
        return k;
    }

    private int appendCount(char[] chars, int count, int index) {
        if (count >= 10) {
            for (char c : String.valueOf(count).toCharArray())
                chars[index++] = c;
        } else if (count > 1)
            chars[index++] = (char) ('0' + count);
        return index;
    }

    public static void main(String[] args) {
        char[] chars = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b',
                'b', 'b' };
        System.out.println(Arrays.copyOf(chars, new StringCompression().compress(chars)));
    }

}
