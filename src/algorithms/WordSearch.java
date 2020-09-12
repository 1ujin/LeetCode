package algorithms;

public class WordSearch {
    
    int h, w, end;
    char[][] board;
    boolean[][] visited;
    char[] cs;

    public boolean exist(char[][] board, String word) {
        h = board.length;
        w = board[0].length;
        end = word.length() - 1;
        this.board = board;
        visited = new boolean[h][w];
        cs = word.toCharArray();
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if (dfs(i, j, 0)) return true;
        return false;
    }

    private boolean dfs(int i, int j, int begin) {
        if (board[i][j] != cs[begin]) return false;
        else if (begin == end) return true;
        visited[i][j] = true;
        begin++;
        if (i > 0 && !visited[i - 1][j] && dfs(i - 1, j, begin)
                || j > 0 && !visited[i][j - 1] && dfs(i, j - 1, begin)
                || i < h - 1 && !visited[i + 1][j] && dfs(i + 1, j, begin)
                || j < w - 1 && !visited[i][j + 1] && dfs(i, j + 1, begin))
            return true;
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' } };
        System.out.println(new WordSearch().exist(board, "ABCCED"));    // true
        System.out.println(new WordSearch().exist(board, "SEE"));       // true
        System.out.println(new WordSearch().exist(board, "ABCB"));      // false
    }

}
