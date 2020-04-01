package algorithms;

import java.util.Arrays;

public class GameOfLife {
    
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (i > 0 && board[i - 1][j] % 3 != 0) count++;
                if (j > 0 && board[i][j - 1] % 3 != 0) count++;
                if (i < m - 1 && board[i + 1][j] % 3 != 0) count++;
                if (j < n - 1 && board[i][j + 1] % 3 != 0) count++;
                if (i > 0 && j > 0 && board[i - 1][j - 1] % 3 != 0) count++;
                if (i > 0 && j < n - 1 && board[i - 1][j + 1] % 3 != 0) count++;
                if (i < m - 1 && j > 0 && board[i + 1][j - 1] % 3 != 0) count++;
                if (i < m - 1 && j < n - 1 && board[i + 1][j + 1] % 3 != 0) count++;
                if ((count < 2 || count > 3) && board[i][j] == 1) board[i][j] = 2;
                else if (count == 3 && board[i][j] == 0) board[i][j] = 3;
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] %= 2;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new GameOfLife().gameOfLife(board);
        for (int[] row : board)
            System.out.println(Arrays.toString(row));
    }

}
