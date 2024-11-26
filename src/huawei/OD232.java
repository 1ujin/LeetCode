package huawei;

import java.util.*;

/**
 * 英文输入法
 */
public class OD232 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        scanner.close();
        System.out.println(solution(s, p));
    }

    private static String solution(String s, String p) {
        char[] cs = s.toCharArray();
        Set<String> words = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z')
                sb.append(c);
            else if (sb.length() > 0) {
                words.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) {
            words.add(sb.toString());
            sb.setLength(0);
        }
        StringJoiner sj = new StringJoiner(" ");
        for (String word : words)
            if (word.startsWith(p))
                sj.add(word);
        return sj.length() == 0 ? p : sj.toString();
    }
}
