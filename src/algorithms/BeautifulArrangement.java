package algorithms;

public class BeautifulArrangement {
    
    private int count, n;
    private boolean[] visited;

    public int countArrangement(int n) {
        this.n = n;
        visited = new boolean[n];
        backtrack(0);
        return count;
    }

    private void backtrack(int i) {
        if (i == n) {
            count++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!visited[j] && ((i + 1) % (j + 1) == 0 || (j + 1) % (i + 1) == 0)) {
                visited[j] = true;
                backtrack(i + 1);
                visited[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new BeautifulArrangement().countArrangement(15));
    }

}
