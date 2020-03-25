package algorithms;

public class AvailableCapturesForRook {
    
    public int numRookCaptures(char[][] board) {
        int col = 0, count = 0;
        boolean sign = false;
        for (int i = 0; i < 8; i++) {
            int leftP = 0, rightP = 0;
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'p' && !sign) leftP = 1;
                if (board[i][j] == 'B' && !sign) leftP = 0;
                if (board[i][j] == 'R') {
                    sign = true;
                    col = j;
                }
                if (board[i][j] == 'p' && sign) rightP = 1;
                if (board[i][j] == 'B' && sign) break;
            }
            if (sign) {
                count += leftP + rightP;
                break;
            }
        }
        if (!sign) return 0;
        sign = false;
        int topP = 0, bottomP = 0;
        for (int i = 0; i < 8; i++) {
            if (board[i][col] == 'p' && !sign) topP = 1;
            if (board[i][col] == 'B' && !sign) topP = 0;
            if (board[i][col] == 'R') sign = true;
            if (board[i][col] == 'p' && sign) bottomP = 1;
            if (board[i][col] == 'B' && sign) break;
        }
        count += topP + bottomP;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new AvailableCapturesForRook().
                numRookCaptures(new char[][] {
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','p','.','.','.','.'},
            {'.','.','.','R','.','.','.','p'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','p','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'}
        }));
    }

}
