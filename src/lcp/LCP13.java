package lcp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LCP13 {
    
    char[][] grid;
    int h, w;
    
    // method 1 dynamic programming
    final int[] dx = { 1, -1, 0, 0 };
    final int[] dy = { 0, 0, 1, -1 };
    
    public int minimalSteps(String[] maze) {
        // 机关 & 石头
        List<int[]> mList = new ArrayList<>(), oList = new ArrayList<>();
        // 起点终点坐标
        int startX = -1, startY = -1, targetX = -1, targetY = -1;
        h = maze.length;
        w = maze[0].length();
        grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            grid[i] = maze[i].toCharArray();
            for (int j = 0; j < w; j++) {
                switch (grid[i][j]) {
                    case 'M':
                        mList.add(new int[] { i, j });
                        break;
                    case 'O':
                        oList.add(new int[] { i, j });
                        break;
                    case 'S':
                        startX = i;
                        startY = j;
                        break;
                    case 'T':
                        targetX = i;
                        targetY = j;
                        break;
                    default:
                        break;
                }
            }
        }
        int mCount = mList.size(), oCount = oList.size();
        int[][] startDist = bfs(startX, startY);
        // 边界情况：没有机关
        if (mCount == 0) return startDist[targetX][targetY];
        // 从某个机关到其他机关 / 起点与终点的最短距离
        int[][] dist = new int[mCount][mCount + 2];
        for (int i = 0; i < mCount; i++)
            Arrays.fill(dist[i], -1);
        // 中间结果
        int[][][] dd = new int[mCount][][];
        for (int i = 0; i < mCount; i++) {
            int[] pos = mList.get(i);
            dd[i] = bfs(pos[0], pos[1]);
            // 从某个点到终点不需要拿石头
            dist[i][mCount + 1] = dd[i][targetX][targetY];
        }
        for (int i = 0; i < mCount; i++) {
            int tmp = -1;
            for (int k = 0; k < oCount; k++) {
                int midX = oList.get(k)[0], midY = oList.get(k)[1];
                if (dd[i][midX][midY] != -1 && startDist[midX][midY] != -1)
                    if (tmp == -1 || tmp > dd[i][midX][midY] + startDist[midX][midY])
                        tmp = dd[i][midX][midY] + startDist[midX][midY];
            }
            dist[i][mCount] = tmp;
            for (int j = i + 1; j < mCount; j++) {
                int mn = -1;
                for (int k = 0; k < oCount; k++) {
                    int midX = oList.get(k)[0], midY = oList.get(k)[1];
                    if (dd[i][midX][midY] != -1 && dd[j][midX][midY] != -1)
                        if (mn == -1 || mn > dd[i][midX][midY] + dd[j][midX][midY])
                            mn = dd[i][midX][midY] + dd[j][midX][midY];
                }
                dist[i][j] = mn;
                dist[j][i] = mn;
            }
        }
        // 无法达成的情形
        for (int i = 0; i < mCount; i++)
            if (dist[i][mCount] == -1 || dist[i][mCount + 1] == -1)
                return -1;
        // dp 数组， -1 代表没有遍历到
        int[][] dp = new int[1 << mCount][mCount];
        for (int i = 0; i < 1 << mCount; i++)
            Arrays.fill(dp[i], -1);
        for (int i = 0; i < mCount; i++)
            dp[1 << i][i] = dist[i][mCount];
        // 由于更新的状态都比未更新的大，所以直接从小到大遍历即可
        for (int mask = 1; mask < (1 << mCount); mask++) {
            for (int i = 0; i < mCount; i++) {
                // 当前 dp 是合法的
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < mCount; j++) {
                        // j 不在 mask 里
                        if ((mask & (1 << j)) == 0) {
                            int next = mask | (1 << j);
                            if (dp[next][j] == -1 || dp[next][j] > dp[mask][i] + dist[i][j])
                                dp[next][j] = dp[mask][i] + dist[i][j];
                        }
                    }
                }
            }
        }
        int ret = -1;
        int finalMask = (1 << mCount) - 1;
        for (int i = 0; i < mCount; i++)
            if (ret == -1 || ret > dp[finalMask][i] + dist[i][mCount + 1])
                ret = dp[finalMask][i] + dist[i][mCount + 1];
        return ret;
    }
    
    private int[][] bfs(int x, int y) {
        int[][] ret = new int[h][w];
        for (int i = 0; i < h; i++)
            Arrays.fill(ret[i], -1);
        ret[x][y] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pos[0] + dx[i], ny = pos[1] + dy[i];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w
                        && grid[nx][ny] != '#' && ret[nx][ny] == -1) {
                    ret[nx][ny] = ret[pos[0]][pos[1]] + 1;
                    queue.offer(new int[] { nx, ny });
                }
            }
        }
        return ret;
    }

    // error method 不能用贪心算法求最近的目标路径
    int mCount = 0, step = 0;
    int[] start, target;

    public int minimalStepsError(String[] maze) {
        h = maze.length;
        w = maze[0].length();
        grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            grid[i] = maze[i].toCharArray();
            for (int j = 0; j < w; j++) {
                switch (grid[i][j]) {
                    case 'M':
                        mCount++;
                        break;
                    case 'S':
                        start = new int[] { i, j };
                        break;
                    case 'T':
                        target = new int[] { i, j };
                        break;
                    case 'O':
                    default:
                        break;
                }
            }
        }
        for (int i = mCount; i > 0; i--) {
            bfs(start, 'O');
            System.out.println(this.step);
            bfs(start, 'M');
            System.out.println(this.step);
        }
        bfs(start, 'T');
        return start[0] == target[0] && start[1] == target[1] ? step : -1;
    }

    private void bfs(int[] start, char target) {
        int step = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { start[0], start[1], 0});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            char c = grid[pos[0]][pos[1]];
            if (c != 'M' && c != 'O' && c != 'T' && c != 'S' && c != '.') continue;
            if (c == target && pos[2] < step) {
                this.start = pos;
                step = pos[2];
            }
            grid[pos[0]][pos[1]] = (char) (c + 32);
            if (pos[1] > 0)
                queue.offer(new int[] { pos[0], pos[1] - 1, pos[2] + 1 });
            if (pos[1] < w - 1)
                queue.offer(new int[] { pos[0], pos[1] + 1, pos[2] + 1 });
            if (pos[0] > 0)
                queue.offer(new int[] { pos[0] - 1, pos[1], pos[2] + 1 });
            if (pos[0] < h - 1)
                queue.offer(new int[] { pos[0] + 1, pos[1], pos[2] + 1 });
        }
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if (grid[i][j] != '#' && grid[i][j] != 'M' && grid[i][j] != 'O' && grid[i][j] != 'T' && grid[i][j] != 'S' && grid[i][j] != '.')
                    grid[i][j] = (char) (grid[i][j] - 32);
        if (target == 'M') {
            grid[this.start[0]][this.start[1]] = '.';
            mCount--;
        }
        this.step += step;
    }

    public static void main(String[] args) {
        String[] maze = { "S#O", "M..", "M.T" };
        System.out.println(new LCP13().minimalSteps(maze));
    }

}
