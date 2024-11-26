package huawei;

import java.util.*;

/**
 * 连续字母长度
 */
public class OD251 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();
        System.out.println(solution(s, k));
    }

    private static int solution(String s, int k) {
        List<int[]> list = new ArrayList<>();
        char[] cs = s.toCharArray();
        if (cs.length < k)
            return -1;
        char c = cs[0];
        int cnt = 1;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] != c) {
                list.add(new int[] {c - 'a', cnt});
                c = cs[i];
                cnt = 0;
            }
            cnt++;
        }
        list.add(new int[] {c - 'a', cnt});
        list.sort((a, b) -> b[1] - a[1]);
        Set<Integer> set = new HashSet<>();
        for (int[] pair : list) {
            if (set.add(pair[0]))
                k--;
            if (k == 0)
                return pair[1];
        }
        return -1;
    }
}
