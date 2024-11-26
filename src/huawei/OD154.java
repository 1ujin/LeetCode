package huawei;

import java.util.Scanner;

/**
 * 字符串分割
 */
public class OD154 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String s = scanner.next();
        scanner.close();
        System.out.println(solution(k, s));
    }

    private static String solution(int k, String s) {
        String[] words = s.split("-");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < words.length; i++)
            sb.append(words[i]);
        char[] cs = sb.toString().toCharArray();
        sb.setLength(0);
        sb.append(words[0]);
        char[] word = new char[k];
        int j = 0;
        int upperCnt = 0, lowerCnt = 0;
        for (int i = 0; i < cs.length; i++) {
            word[j] = cs[i];
            if (word[j] >= 'A' && word[j] <= 'Z')
                upperCnt++;
            else if (word[j] >= 'a' && word[j] <= 'z')
                lowerCnt++;
            j++;
            if (j == k || i == cs.length - 1) {
                sb.append('-');
                String tail = String.valueOf(word, 0, j);
                if (upperCnt > lowerCnt)
                    sb.append(tail.toUpperCase());
                else if (upperCnt < lowerCnt)
                    sb.append(tail.toLowerCase());
                else
                    sb.append(tail);
                j = 0;
                upperCnt = 0;
                lowerCnt = 0;
            }
        }
        return sb.toString();
    }
}
