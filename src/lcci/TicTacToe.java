package lcci;

public class TicTacToe {
    
    public String tictactoe(String[] board) {
        int N = board.length;
        boolean space = false, xSign = false;
        // row
        for (String row : board) {
            if (row.indexOf('X') < 0 && row.indexOf(' ') < 0) return "O";
            else if (row.indexOf('O') < 0 && row.indexOf(' ') < 0) xSign = true;
            else if (row.indexOf(' ') > -1) space = true;
        }
        if (xSign) return "X";
        // forward diagonal
        int o = 0, x = 0;
        for (int i = 0; i < N; i++) {
            char c = board[i].charAt(i);
            if (c == 'O') o++;
            else if (c == 'X') x++;
        }
        if (o == N) return "O";
        else if (x == N) return "X";
        // backward diagonal
        o = 0; x = 0;
        for (int i = 0; i < N; i++) {
            char c = board[i].charAt(N - 1 - i);
            if (c == 'O') o++;
            else if (c == 'X') x++;
        }
        if (o == N) return "O";
        else if (x == N) return "X";
        // column
        for (int i = 0; i < N; i++) {
            o = 0; x = 0;
            for (int j = 0; j < N; j++) {
                char c = board[j].charAt(i);
                if (c == 'O') o++;
                else if (c == 'X') x++;
            }
            if (o == N) return "O";
            if (x == N) xSign = true;
        }
        if (xSign) return "X";
        return space ? "Pending" : "Draw";
    }

    public static void main(String[] args) {
        System.out.println(new TicTacToe().
                tictactoe(new String[] {"OOX","XXO","OX "}));
    }

}
