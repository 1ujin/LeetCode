package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {
    
    char[] cs;
    List<Integer> F = new ArrayList<>();

    public List<Integer> splitIntoFibonacci(String S) {
        cs = S.toCharArray();
        backtrack(0, 0, 0);
        return F;
    }

    private boolean backtrack(int index, int sum, int prev) {
        if (index == cs.length) return F.size() >= 3;
        long temp = 0l;
        for (int i = index; i < cs.length && (i <= index || cs[index] != '0'); i++) {
            temp = temp * 10 + cs[i] - '0';
            if (temp > Integer.MAX_VALUE) break;
            int curr = (int) temp;
            if (F.size() >= 2) {
                if (curr < sum) continue;
                else if (curr > sum) break;
            }
            F.add(curr);
            if (backtrack(i + 1, prev + curr, curr)) return true;
            else F.remove(F.size() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SplitArrayIntoFibonacciSequence()
                .splitIntoFibonacci("123456579"));
    }

}
