package algorithms;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= Math.min(9, n); i++)
            dfs(i, n);
        return list;
    }

    private void dfs(int num, int n) {
        if (num > n)
            return;
        list.add(num);
        for (int i = 0; i <= 9; i++) {
            if (num * 10 + i > n)
                break;
            dfs(num * 10 + i, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LexicographicalNumbers().lexicalOrder(13));
    }

}
