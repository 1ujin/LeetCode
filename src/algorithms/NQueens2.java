package algorithms;

import java.util.HashSet;
import java.util.Set;

public class NQueens2 {

    int total = 0, row = 0;
    
    // method 1 backtracking
    Set<Integer> cols = new HashSet<Integer>();
    Set<Integer> forwardDiagnols = new HashSet<Integer>();
    Set<Integer> backwardDiagnols = new HashSet<Integer>();
    
    public int totalNQueens1(int n) {
        for (int col = 0; col < n; col++) {
            if (!cols.contains(col) && !forwardDiagnols.contains(row + col) && !backwardDiagnols.contains(n - 1 - row + col)) {
                if (row >= n - 1) total++;
                row++;
                cols.add(col);
                forwardDiagnols.add(row + col);
                backwardDiagnols.add(n - 1 - row + col);
                totalNQueens1(n);
                row--;
                cols.remove(col);
                forwardDiagnols.remove(row + col);
                backwardDiagnols.remove(n - 1 - row + col);
            }
        }
        return total;
    }
    
    // method 2 bitmap fastest
    int colBmp = 0, frdBmp = 0, bkdBmp = 0;
    
    public int totalNQueens2(int n) {
        if (row >= n) total++;
        // 获得可用位置的位图：将占用位置的位图求或取反并将高于 n 位的清零
        int vacancies = ~(colBmp | frdBmp | bkdBmp) & ((1 << n) - 1);
        while (vacancies != 0) {
            // 获取可用位置位图的最低位
            int qBit = vacancies & -vacancies;
            row++;
            // 或运算占用
            colBmp |= qBit;
            frdBmp |= qBit;
            // 判断丢失的末位并在右移后保存于首位
            if ((frdBmp & 1) == 1 && frdBmp >> 1 > 0) {
                frdBmp >>= 1;
                frdBmp |= Integer.MIN_VALUE;
            } else if ((frdBmp & 1) == 0 && frdBmp >> 1 < 0) {
                frdBmp >>= 1;
                frdBmp ^= Integer.MIN_VALUE;
            } else frdBmp >>= 1;
            bkdBmp |= qBit;
            bkdBmp <<= 1;
            totalNQueens2(n);
            row--;
            // 异或运算取消占用
            colBmp ^= qBit;
            // 若首位为 1 则在左移后追加到末位
            if (frdBmp < 0) {
                frdBmp <<= 1;
                frdBmp += 1;
            } else frdBmp <<= 1;
            frdBmp ^= qBit;
            bkdBmp >>= 1;
            bkdBmp ^= qBit;
            // 此位置所有分支已经遍历完毕
            vacancies &= vacancies - 1;
        }
        return total;
    }

    public static void main(String[] args) {
        NQueens2 solution = new NQueens2();
        long startTime = System.nanoTime();
        int result = solution.totalNQueens2(8);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
