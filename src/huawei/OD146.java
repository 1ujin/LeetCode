package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 敏感字段加密
 */
public class OD146 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String s = scanner.next();
        scanner.close();
        System.out.println(solution(k, s));
    }

    private static String solution(int k, String s) {
        s = s + "_";
        String[] quotes = s.split("\"");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < quotes.length; i++) {
            if (i % 2 == 0) {
                for (String word : List.of(quotes[i].split("_")))
                    if (word.length() > 0)
                        list.add(word);
            } else {
                list.add("\"" + quotes[i] + "\"");
            }
        }
        if (list.size() <= k)
            return "ERROR";
        list.set(k, "******");
        return String.join("_", list);
    }
}
