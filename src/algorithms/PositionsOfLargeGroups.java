package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PositionsOfLargeGroups {
    
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        char[] cs = s.toCharArray();
        for (int i = 0, count = 1; i < cs.length; i++) {
            if (i == cs.length - 1 || cs[i] != cs[i + 1]) {
                if (count >= 3) {
                    current.add(i - count + 1);
                    current.add(i);
                    list.add(current);
                    current = new ArrayList<>();
                }
                count = 1;
            } else count++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new PositionsOfLargeGroups().largeGroupPositions("abcdddeeeeaabbbcd"));
    }

}
