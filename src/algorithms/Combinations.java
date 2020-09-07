package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    
    // method 1 bitmap
    public List<List<Integer>> combine1(int n, int k) {
        int max = -1 >>> 32 - n;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            if (Integer.bitCount(i) != k) continue;
            List<Integer> list = new ArrayList<>();
            int j = i, num = 1;
            while (j != 0) {
                if ((j & 1) != 0)
                    list.add(num);
                num++;
                j >>>= 1;
            }
            lists.add(list);
        }
        return lists;
    }
    
    // method 2 backtracking fastest
    List<List<Integer>> lists = new ArrayList<>();
    
    public List<List<Integer>> combine2(int n, int k) {
        backTrack(new ArrayList<>(), 1, n, k);
        return lists;
    }

    private void backTrack(List<Integer> list, int begin, int n, int k) {
        if (k == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i < n - k + 2; i++) {
            list.add(i);
            backTrack(list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine2(4, 2));
    }

}
