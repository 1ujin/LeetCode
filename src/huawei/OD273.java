package huawei;

import java.util.*;

/**
 * 增强的 strstr
 */
public class OD273 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        scanner.close();
        List<Set<Character>> list = new ArrayList<>();
        Set<Character> set = null;
        boolean flag = false;
        for (char c : t.toCharArray()) {
            if (c == '[') {
                flag = true;
                set = new HashSet<>();
            } else if (c == ']') {
                flag = false;
                list.add(set);
            } else if (flag) {
                set.add(c);
            } else {
                set = new HashSet<>();
                set.add(c);
                list.add(set);
            }
        }
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            Iterator<Set<Character>> iterator = list.listIterator();
            int j = i;
            while (iterator.hasNext() && j < cs.length) {
                if (iterator.next().contains(cs[j]))
                    j++;
                else
                    break;
            }
            if (j - i == list.size()) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
