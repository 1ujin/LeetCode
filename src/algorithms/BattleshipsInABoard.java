package algorithms;

public class BattleshipsInABoard {

    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length, ship = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'X')
                    continue;
                if (i > 0 && board[i - 1][j] == 'X')
                    continue;
                if (j > 0 && board[i][j - 1] == 'X')
                    continue;
                ship++;
            }
        }
        return ship;
    }

    public static void main(String[] args) {
        char[][] board = { { 'X', '.', '.', 'X' }, { '.', '.', '.', 'X' },
                { '.', '.', '.', 'X' }, { '.', '.', '.', '.' } };
        System.out.println(new BattleshipsInABoard().countBattleships(board));
    }

}
