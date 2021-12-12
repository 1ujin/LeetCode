package algorithms;

public class MaxIncreaseToKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, sum = 0;
        int[] ver = new int[n], hor = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ver[i] = Math.max(ver[i], grid[i][j]);
                hor[j] = Math.max(hor[j], grid[i][j]);
            }
        }
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                sum += Math.min(ver[j], hor[i]) - grid[i][j];
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = { 
                { 3, 0, 8, 4 },
                { 2, 4, 5, 7 },
                { 9, 2, 6, 3 },
                { 0, 3, 1, 0 } };
        System.out.println(new MaxIncreaseToKeepCitySkyline()
                .maxIncreaseKeepingSkyline(grid));
    }

}
