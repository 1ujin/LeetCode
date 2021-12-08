package algorithms;

public class ValidTicTacToeState {

    public boolean validTicTacToe(String[] board) {
        int countX = 0, countO = 0;
        char[][] grid = new char[3][3];
        for (int i = 0; i < 3; i++)
            grid[i] = board[i].toCharArray();
        for (char[] row : grid) {
            for (char c : row) {
                if (c == 'X')
                    countX++;
                else if (c == 'O')
                    countO++;
            }
        }
        if (countX < countO || countX - countO > 1)
            return false;
        if (win(grid, 'X') && countX - countO != 1)
            return false;
        if (win(grid, 'O') && countX != countO)
            return false;
        return true;
    }

    private boolean win(char[][] grid, char c) {
        for (int i = 0; i < 3; i++) {
            if (c == grid[0][i] && c == grid[1][i] && c == grid[2][i])
                return true;
            if (c == grid[i][0] && c == grid[i][1] && c == grid[i][2])
                return true;
        }
        if (c == grid[0][0] && c == grid[1][1] && c == grid[2][2])
            return true;
        if (c == grid[0][2] && c == grid[1][1] && c == grid[2][0])
            return true;
        return false;
    }

    public static void main(String[] args) {
        String[] board = { "XOX", "O O", "XOX" };
        System.out.println(new ValidTicTacToeState().validTicTacToe(board));
    }

}
