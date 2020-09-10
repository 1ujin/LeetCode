package algorithms;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    
    List<List<Integer>> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(new ArrayList<>(), 1, k, n);
        return list;
    }

    private void backTrack(List<Integer> list, int begin, int k, int n) {
        if (n == 0 && k == 0)
            this.list.add(new ArrayList<>(list));
        else for (int i = begin; i < 10 && i <= n; i++) {
            list.add(i);
            backTrack(list, i + 1, k - 1, n - i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3, 9));
    }

}
