package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LangtonsAnt {
    
    private class Position {
        
        int x, y;
        
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Position)) return false;
            Position o = (Position) obj;
            return x == o.x && y == o.y;
        }
        
        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
    
    public List<String> printKMoves(int K) {
        char[] direction = {'L', 'U', 'R', 'D'};
        int[][] offset = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Position antPos = new Position(0, 0);
        int antDir = 2;
        Set<Position> blackSet = new HashSet<>();
        while (K > 0) {
            Position t = new Position(antPos.x, antPos.y);
            if (blackSet.add(t)) antDir = (antDir + 1) % 4;
            else {
                antDir = (antDir + 3) % 4;
                blackSet.remove(t);
            }
            antPos.x += offset[antDir][0];
            antPos.y += offset[antDir][1];
            K--;
        }
        int left = antPos.x, top = antPos.y, right = antPos.x, bottom = antPos.y;
        for (Position pos : blackSet) {
            left = pos.x < left ? pos.x : left;
            top = pos.y < top ? pos.y : top;
            right = pos.x > right ? pos.x : right;
            bottom = pos.y > bottom ? pos.y : bottom;
        }
        char[][] grid = new char[bottom - top + 1][right - left + 1];
        for (char[] row : grid)
            Arrays.fill(row, '_');
        for (Position pos : blackSet)
            grid[pos.y - top][pos.x - left] = 'X';
        grid[antPos.y - top][antPos.x - left] = direction[antDir];
        List<String> result = new ArrayList<>();
        for (char[] row : grid)
            result.add(String.valueOf(row));
        return result;
    }

    public static void main(String[] args) {
        List<String> result = new LangtonsAnt().printKMoves(20);
        for (String string : result)
            System.out.println(string);
    }

}
