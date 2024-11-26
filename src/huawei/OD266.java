package huawei;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 考勤信息
 */
public class OD266 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }
        scanner.close();
        System.out.println(solution(n, arr));
    }

    private static String solution(int n, String[] arr) {
        StringJoiner sj = new StringJoiner(" ");
        for (String a : arr) {
            int absent = 0, present = 0;
            String[] words = a.split(" ");
            boolean result = true;
            for (int i = 0; i < words.length && result; i++) {
                if (i != 0 && (
                        words[i - 1].equals("late") && words[i].equals("late") ||
                        words[i - 1].equals("leaveearly") && words[i].equals("leaveearly") ||
                        words[i - 1].equals("late") && words[i].equals("leaveearly") ||
                        words[i - 1].equals("leaveearly") && words[i].equals("late"))) {
                    result = false;
                    break;
                } else if (words[i].equals("absent")) {
                    absent++;
                    if (absent > 1) {
                        result = false;
                        break;
                    }
                } else if (words[i].equals("present")) {
                    present++;
                }
                if (i >= 6) {
                    if (present < 4) {
                        result = false;
                        break;
                    }
                    if (words[i - 6].equals("present"))
                        present--;
                }
            }
            if (!result)
                sj.add(String.valueOf(false));
            else if (absent > 1)
                sj.add(String.valueOf(false));
            else
                sj.add(String.valueOf(result));
        }
        return sj.toString();
    }
}
