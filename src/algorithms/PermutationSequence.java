package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    
    // method 1 backtracking
    int n, k;
    boolean[] bs;
    StringBuilder sb = new StringBuilder();
    
    public String getPermutation1(int n, int k) {
        this.n = n;
        this.k = k;
        bs = new boolean[n];
        backTrack();
        return sb.toString();
    }
    
    private void backTrack() {
        if (k == 0) return;
        else if (sb.length() == n) k--;
        else for (int i = 0; i < n; i++) {
            if (bs[i]) continue;
            sb.append((char) ('1' + i));
            bs[i] = true;
            backTrack();
            if (k == 0) break;
            bs[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    // method 2 阶乘
    public String getPermutation2(int n, int k) {
        int[] factorials = new int[n];
        List<Integer> list = new ArrayList<>();
        factorials[0] = 1;
        list.add(1);
        for (int i = 1; i < n; i++) {
            factorials[i] = factorials[i - 1] * i;
            list.add(i + 1);
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i > -1; i--) {
            int index = k / factorials[i];
            k -= index * factorials[i];
            sb.append(list.get(index));
            list.remove(index);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation2(3, 3));
    }

}
