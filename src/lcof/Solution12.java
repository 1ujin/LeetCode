package lcof;

public class Solution12 {

    private int h, w;
    private char[] cs;
    private char[][] board;
    
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return false;
        h = board.length;
        w = board[0].length;
        cs = word.toCharArray();
        this.board = board;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if (board[i][j] == cs[0])
                    if (dfs(i, j, 0))
                        return true;
        return false;
    }

    private boolean dfs(int i, int j, int k) {
        char c = board[i][j];
        if (c != cs[k])
            return false;
        if (c == cs[k])
            board[i][j] = ' ';
        if (k == cs.length - 1)
            return true;
        boolean result = (i > 0 && dfs(i - 1, j, k + 1)) ||
                (j > 0 && dfs(i, j - 1, k + 1)) ||
                (i < h - 1 && dfs(i + 1, j, k + 1)) ||
                (j < w - 1 && dfs(i, j + 1, k + 1));
        if (!result)
            board[i][j] = c;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'E', 'S' },
                { 'A', 'D', 'E', 'E' } };
        System.out.println(new Solution12().exist(board, "ABCESEEEFS"));
    }

}
