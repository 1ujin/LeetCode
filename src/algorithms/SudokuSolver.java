package algorithms;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {
    
    // method 1 backtracking
    static char[][] board;
    static Set<Character> [] horizontalSets;
    static Set<Character> [] verticalSets;
    static Set<Character> [] latticeSets;
    
    @SuppressWarnings("unchecked")
    public static void solveSudoku1(char[][] board) {
        SudokuSolver.board = board;
        horizontalSets = new Set[9];
        verticalSets = new Set[9];
        latticeSets = new Set[9];
        for (int i = 0; i < 9; i++) {
            horizontalSets[i] = new HashSet<>();
            verticalSets[i] = new HashSet<>();
            latticeSets[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int lattice = (i / 3) * 3 + j / 3;
                    horizontalSets[i].add(c);
                    verticalSets[j].add(c);
                    latticeSets[lattice].add(c);
                }
            }
        }
        backtrack(0);
    }
    
    public static boolean backtrack(int n) {
        if (n == 81)
            return true;
        int i = n / 9, j = n % 9;
        if (board[i][j] != '.') {
            return(backtrack(n + 1));
        } else {
            for (char c = '1'; c <= '9'; c++) {
                int lattice = (i / 3) * 3 + j / 3;
                if (latticeSets[lattice].contains(c) ||
                        horizontalSets[i].contains(c) ||
                        verticalSets[j].contains(c)) {
                    if (c == '9')
                        return false;
                    else
                        continue;
                }
                board[i][j] = c;
                horizontalSets[i].add(c);
                verticalSets[j].add(c);
                latticeSets[lattice].add(c);
                if (backtrack(n + 1))
                    return true;
                board[i][j] = '.';
                horizontalSets[i].remove(c);
                verticalSets[j].remove(c);
                latticeSets[lattice].remove(c);
            }
            return false;
        }
    }
    
    
    // method 2 fastest
    static final int N = 9;
    static int[] row = new int [N], col = new int [N];
    //ones数组表示0~2^9 - 1的整数中二进制表示中1的个数:如ones[7] = 3 ones[8] = 1
    //map数组表示2的整数次幂中二进制1所在位置（从0开始） 如 map[1] = 0,map[2] = 1, map[4] = 2
    static int[] ones = new int[1 << N], map = new int[1 << N];
    static int[][] cell = new int[3][3];
    
    public static void solveSudoku2(char[][] board) {
        init();
        int cnt = fill_state(board);
        dfs(cnt, board);
    }
    
    static void init() {
        for (int i = 0; i < N; i++) row[i] = col[i] = (1 << N) - 1; 
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                cell[i][j] = (1 << N) - 1;
        //以上2个循环把数组的数初始化为二进制表示9个1，即一开始所以格子都可填
        for (int i = 0; i < N; i++) map[1 << i] = i;
        //统计0~2^9 - 1的整数中二进制表示中1的个数
        for (int i = 0; i < 1 << N; i++) {
            int n = 0;
            for (int j = i; j != 0; j ^= lowBit(j)) n++;
            ones[i] = n;
        }
    }
    
    static int fill_state(char[][] board) {
        int cnt = 0;    //统计board数组空格('.')的个数
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '1';
                    //数独中 i,j位置为数组下标，修改row col cell数组中状态
                    change_state(i, j, t);  
                } else cnt++;
            }
        }
        return cnt;
    }
    
    static boolean dfs(int cnt, char[][] board) {
        if (cnt == 0) return true;
        int min = 10, x = 0, y = 0;
        //剪枝，即找出当前所以空格可填数字个数最少的位置 记为x y
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') {
                    int k = ones[get(i, j)];
                    if (k < min) {
                        min = k;
                        x = i;
                        y = j;
                    }
                }
            }
        }
        //遍历当前 x y所有可选数字
        for (int i = get(x, y); i != 0; i ^= lowBit(i)) {
            int t = map[lowBit(i)];
            
            change_state(x, y, t);
            board[x][y] = (char) ('1' + t);
            
            if (dfs(cnt - 1, board)) return true;
            
            //恢复现场
            change_state(x, y, t);
            board[x][y] = '.';
        }
        return false;
    }
    
    static void change_state(int x, int y, int t) {
        row[x] ^= 1 << t;
        col[y] ^= 1 << t;
        cell[x / 3][y / 3] ^= 1 << t;
    }
    
    //对维护数组x行,y列的3个集合(行、列、九宫格)进行&运算
    //就可以获得可选数字的集合(因为我们用1标识可填数字)
    static int get(int x, int y) {
        return row[x] & col[y] & cell[x / 3][y / 3];
    }
    
    static int lowBit(int x) {
        return -x & x;
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
        solveSudoku2(board);
        long endTime = System.nanoTime();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++)
                System.out.printf(board[i][j] + " ");
            System.out.println();
        }
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
