package lcci;

import java.util.ArrayList;
import java.util.List;

public class EightQueens {
    
    int n, cols, frds, bkds;
    List<List<String>> result;
    
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        cols = 0; frds = 0; bkds = 0;
        result = new ArrayList<>();
        backtrack(new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(List<String> strs, int row) {
        List<String> tmp = new ArrayList<>(strs);
        for (int col = 0; col < n; col++) {
            if ((cols & 1 << col) + (frds & 1 << row + col) + (bkds & 1 << n - 1 - row + col) == 0) {
                cols += 1 << col;
                frds += 1 << row + col;
                bkds += 1 << n - 1 - row + col;
                char[] chars = new char[n];
                for (int j = 0; j < n; j++) chars[j] = '.';
                chars[col] = 'Q';
                tmp.add(String.valueOf(chars));
                if (row == n - 1) result.add(new ArrayList<>(tmp));
                else backtrack(tmp, row + 1);
                tmp.remove(row);
                cols -= 1 << col;
                frds -= 1 << row + col;
                bkds -= 1 << n - 1 - row + col;
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<List<String>> result = new EightQueens().solveNQueens(8);
        long endTime = System.nanoTime();
        for (List<String> list : result) {
            for (String string : list)
                System.out.println(string);
            System.out.println();
        }
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
