package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class NQueens {
    
    Set<Integer> cols = new HashSet<Integer>();
    Set<Integer> slashes = new HashSet<Integer>();
    Set<Integer> backslashes = new HashSet<Integer>();
    List<List<String>> result = new ArrayList<>();
    Stack<Integer> qStack = new Stack<>();
    
    public List<List<String>> solveNQueens(int n) {
        backtrack(0, n);
        return result;
    }
    
    private void backtrack(int i, int n) {
        for (int j = 0; j < n; j++) {
            if (!cols.contains(j) && !slashes.contains(i + j) && !backslashes.contains(7 - i + j)) {
                qStack.push(j);
                if (qStack.size() == n) {
                    List<String> list = new ArrayList<>();
                    for (Integer col : qStack) {
                        StringBuilder sb = new StringBuilder();
                        for (int l = 0; l < n; l++)
                            sb.append('.');
                        sb.setCharAt(col, 'Q');
                        list.add(sb.toString());
                    }
                    result.add(list);
                }
                cols.add(j);
                slashes.add(i + j);
                backslashes.add(7 - i + j);
                backtrack(i + 1, n);
                qStack.pop();
                cols.remove(j);
                slashes.remove(i + j);
                backslashes.remove(7 - i + j);
            }
        }
    }

    public static void main(String[] args) {
        NQueens solution = new NQueens();
        long startTime = System.nanoTime();
        List<List<String>> result = solution.solveNQueens(8);
        long endTime = System.nanoTime();
        for (List<String> list : result) {
            for (String string : list)
                System.out.println(string);
            System.out.println();
        }
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
