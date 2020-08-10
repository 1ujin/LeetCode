package algorithms;

import java.util.Arrays;

public class SurroundedRegions {
    
    char[][] board;
    int h, w;
    
    public void solve(char[][] board) {
        this.board = board;
        h = board.length;
        w = board[0].length;
        for (int i = 0; i < h; i++) {
            dfs(i, 0);
            dfs(i, w - 1);
        }
        for (int i = 1; i < w - 1; i++) {
            dfs(0, i);
            dfs(h - 1, i);
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == '.')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= h || j < 0 || j >= w || board[i][j] != 'O') return;
        board[i][j] = '.';
        dfs(i - 1, j);
        dfs(i, j - 1);
        dfs(i + 1, j);
        dfs(i, j + 1);
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'O', 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'O', 'X', 'O' },
                { 'X', 'O', 'X', 'O', 'X' },
                { 'O', 'X', 'O', 'O', 'O' },
                { 'X', 'X', 'O', 'X', 'O' } };
        new SurroundedRegions().solve(board);
        for (char[] row : board)
            System.out.println(Arrays.toString(row));
    }

}
