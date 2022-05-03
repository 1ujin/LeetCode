package algorithms;

import java.util.Arrays;

public class ReorderDataInLogFiles {

    private static class Pair {
        String id;
        String content;
        int index;

        public Pair(String id, String content, int index) {
            this.id = id;
            this.content = content;
            this.index = index;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        int len = logs.length;
        Pair[] pairs = new Pair[len];
        for (int i = 0; i < len; i++) {
            String[] log = logs[i].split(" ", 2);
            pairs[i] = new Pair(log[0], log[1], i);
        }
        Arrays.sort(pairs, (a, b) -> {
            char c1 = a.content.charAt(0), c2 = b.content.charAt(0);
            boolean isDigit1 = '0' <= c1 && c1 <= '9';
            boolean isDigit2 = '0' <= c2 && c2 <= '9';
            if (isDigit1 && isDigit2)
                return a.index - b.index;
            if (!isDigit1 && !isDigit2) {
                int sc = a.content.compareTo(b.content);
                if (sc != 0)
                    return sc;
                return a.id.compareTo(b.id);
            }
            return isDigit1 ? 1 : -1;
        });
        String[] reordered = new String[len];
        for (int i = 0; i < len; i++)
            reordered[i] = pairs[i].id + ' ' + pairs[i].content;
        return reordered;
    }

    public static void main(String[] args) {
        String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6",
                "let2 own kit dig", "let3 art zero" };
        System.out.println(Arrays.toString(new ReorderDataInLogFiles()
                .reorderLogFiles(logs)));
    }

}
