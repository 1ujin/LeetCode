package algorithms;

public class NumberOfProvinces {
    
    private int[][] isConnected;
    private boolean[] visited;
    private int num = 0;
    
    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;
        visited = new boolean[isConnected.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            num++;
            dfs(i);
        }
        return num;
    }

    private void dfs(int i) {
        visited[i] = true;
        for (int j = 0; j < visited.length; j++)
            if (i != j && !visited[j] && isConnected[i][j] == 1)
                dfs(j);
    }

    public static void main(String[] args) {
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(new NumberOfProvinces().findCircleNum(isConnected));
    }

}
