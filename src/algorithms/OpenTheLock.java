package algorithms;

import java.util.HashSet;
import java.util.Set;

public class OpenTheLock {

    int openLock(String[] deadends, String target) {
        Set<String> set1 = new HashSet<>(), set2 = new HashSet<>(),
                deads = new HashSet<>(), visited = new HashSet<>();
        for (String s : deadends)
            deads.add(s);
        int step = 0;
        set1.add("0000");
        set2.add(target);
        while (!set1.isEmpty() && !set2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String cur : set1) {
                if (deads.contains(cur))
                    continue;
                if (set2.contains(cur))
                    return step;
                visited.add(cur);
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up))
                        temp.add(up);
                    String down = minusOne(cur, j);
                    if (!visited.contains(down))
                        temp.add(down);
                }
            }
            step++;
            set1 = set2;
            set2 = temp;
        }
        return -1;
    }

    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j]++;
        return new String(ch);
    }

    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j]--;
        return new String(ch);
    }

    public static void main(String[] args) {
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        System.out.println(new OpenTheLock().openLock(deadends, "0202"));
    }

}
