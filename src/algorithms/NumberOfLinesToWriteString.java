package algorithms;

import java.util.Arrays;

public class NumberOfLinesToWriteString {

    public int[] numberOfLines(int[] widths, String s) {
        int line = 1, buffer = 0;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (buffer + width > 100) {
                buffer = 0;
                line++;
            }
            buffer += width;
        }
        return new int[] { line, buffer };
    }

    public static void main(String[] args) {
        int[] widths = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
        System.out.println(Arrays.toString(new NumberOfLinesToWriteString()
                .numberOfLines(widths, "abcdefghijklmnopqrstuvwxyz")));
    }

}
