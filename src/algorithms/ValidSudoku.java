package algorithms;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    
    // method 1
    public static boolean isValidSudoku1(char[][] board) {
        Set<Character> [] horizontalSets = new Set[9];
        Set<Character> [] verticalSets = new Set[9];
        Set<Character> [] nineLatticeSets = new Set[9];
        for (int i = 0; i < 9; i++) {
            horizontalSets[i] = new HashSet<>();
            verticalSets[i] = new HashSet<>();
            nineLatticeSets[i] = new HashSet<>();
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (horizontalSets[i].contains(c)) return false;
                    if (verticalSets[j].contains(c)) return false;
                    int lattice = (i / 3) * 3 + j / 3;
                    if (nineLatticeSets[lattice].contains(c)) return false;
                    horizontalSets[i].add(c);
                    verticalSets[j].add(c);
                    nineLatticeSets[lattice].add(c);
                }
            }
        }
        return true;
    }
    
    // method 2 fastest
    public static boolean isValidSudoku2(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] sub = new int[9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                //当前字符是'.'则跳过, 直接进入下一轮循环
                if(board[i][j] == '.')
                    continue;
                //处理行
                if(!valid(row, i, board[i][j] - 48))
                    return false;
                //处理列
                if(!valid(col, j, board[i][j] - 48))
                    return false;
                //处理子数独
                int index = i / 3 * 3 + j / 3;
                if(!valid(sub, index, board[i][j] - 48))
                    return false;
            }
        }
        return true;
    }
    
    public static boolean valid(int[] arr, int i, int cur){
        //cur出现过, 返回false
        if(((arr[i]>>cur)&1)==1)
            return false;
        //cur没出现过, 标记为出现过
        arr[i] = arr[i] | (1<<cur);
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'},
        };
        long startTime = System.nanoTime();
        boolean isSudoku = isValidSudoku2(board);
        long endTime = System.nanoTime();
        System.out.println(isSudoku);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
