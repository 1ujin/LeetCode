package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PondSizes {
    
    private int[][] land;
    private int row, col;
    private List<Integer> ponds;

    public int[] pondSizes(int[][] land) {
        this.land = land;
        row = land.length;
        col = land[0].length;
        ponds = new ArrayList<>();
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (land[i][j] == 0)
                    ponds.add(dfs(i, j, 0));
        int[] result = ponds.stream().mapToInt(i -> i).toArray();
        Arrays.sort(result);
        return result;
    }

    private int dfs(int i, int j, int size) {
        size++;
        land[i][j] = 1;
        if (i > 0 && land[i - 1][j] == 0)
            size = dfs(i - 1, j, size);
        if (i < row - 1 && land[i + 1][j] == 0)
            size = dfs(i + 1, j, size);
        if (j > 0 && land[i][j - 1] == 0)
            size = dfs(i, j - 1, size);
        if (j < col - 1 && land[i][j + 1] == 0)
            size = dfs(i, j + 1, size);
        if (i > 0 && j > 0 && land[i - 1][j - 1] == 0)
            size = dfs(i - 1, j - 1, size);
        if (i < row - 1 && j < col - 1 && land[i + 1][j + 1] == 0)
            size = dfs(i + 1, j + 1, size);
        if (i > 0 && j < col - 1 && land[i - 1][j + 1] == 0)
            size = dfs(i - 1, j + 1, size);
        if (i < row - 1 && j > 0 && land[i + 1][j - 1] == 0)
            size = dfs(i + 1, j - 1, size);
        return size;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PondSizes().
                pondSizes(new int[][] {
                    {0, 2, 1, 0},
                    {0, 1, 0, 1},
                    {1, 1, 0, 1},
                    {0, 1, 0, 1}
                })));
    }

}
