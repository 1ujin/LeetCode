package algorithms;

import java.util.Arrays;

public class Minesweeper {
    
    char[][] board;
    int h, w;

    public char[][] updateBoard(char[][] board, int[] click) {
        this.board = board;
        h = board.length;
        w = board[0].length;
        if (board[click[0]][click[1]] == 'M')
            board[click[0]][click[1]] = 'X';
        else dfs(click[0], click[1]);
        return board;
    }

    private void dfs(int x, int y) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i != 0 || j != 0) {
                    x += i;
                    y += j;
                    if (x >= 0 && x < h && y >= 0 && y < w && board[x][y] == 'M')
                        count++;
                    x -= i;
                    y -= j;
                }
            }
        }
        if (count != 0) {
            board[x][y] = (char) ('0' + count);
            return;
        }
        board[x][y] = 'B';
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i != 0 || j != 0) {
                    x += i;
                    y += j;
                    if (x >= 0 && x < h && y >= 0 && y < w && board[x][y] == 'E')
                        dfs(x, y);
                    x -= i;
                    y -= j;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'E', 'E', 'E', 'E', 'E' },
                { 'E', 'E', 'M', 'E', 'E' },
                { 'E', 'E', 'E', 'E', 'E' },
                { 'E', 'E', 'E', 'E', 'E' } };
        int[] click = { 3, 0 };
        for (char[] row : new Minesweeper().updateBoard(board, click))
            System.out.println(Arrays.toString(row));
    }

}
