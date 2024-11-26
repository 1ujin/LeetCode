package huawei;

import java.util.*;

/**
 * 智能成绩表
 */
public class OD362 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        String[] subjects = new String[m];
        for (int i = 0; i < m; i++)
            subjects[i] = scanner.next();
        String[] students = new String[n];
        int[][] scores = new int[n][m + 2];
        for (int i = 0; i < n; i++) {
            students[i] = scanner.next();
            scores[i][m + 1] = i;
            for (int j = 0; j < m; j++)
                scores[i][j] = scanner.nextInt();
        }
        String query = scanner.next();
        scanner.close();
        int subIdx = 0;
        while (subIdx < m && !subjects[subIdx].equals(query))
            subIdx++;
        if (subIdx == m) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    scores[i][m] += scores[i][j];
        }
        int finalSubIdx = subIdx;
        Arrays.sort(scores, (a, b) -> a[finalSubIdx] != b[finalSubIdx] ? b[finalSubIdx] - a[finalSubIdx] : students[a[m + 1]].compareTo(students[b[m + 1]]));
        StringJoiner sj = new StringJoiner(" ");
        for (int[] score : scores)
            sj.add(students[score[m + 1]]);
        System.out.println(sj);
    }
}
