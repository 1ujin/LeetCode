package lcci;

import java.util.ArrayList;
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
        Set<Position> set = new HashSet<>(), blackSet = new HashSet<>();
        set.add(new Position(0, 0));
        while (K > 0) {
            Position t = new Position(antPos.x, antPos.y);
            if (blackSet.add(t)) antDir = Math.floorMod(antDir + 1, 4);
            else {
                antDir = Math.floorMod(antDir - 1, 4);
                blackSet.remove(t);
            }
            antPos.x += offset[antDir][0];
            antPos.y += offset[antDir][1];
            set.add(new Position(antPos.x, antPos.y));
            K--;
        }
        int left = 0, top = 0, right = 0, bottom = 0;
        for (Position pos : set) {
            left = pos.x < left ? pos.x : left;
            top = pos.y < top ? pos.y : top;
            right = pos.x > right ? pos.x : right;
            bottom = pos.y > bottom ? pos.y : bottom;
        }
        List<String> result = new ArrayList<>();
        for (int i = top; i <= bottom; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = left; j <= right; j++) {
                if (j == antPos.x && i == antPos.y) {
                    sb.append(direction[antDir]);
                } else if (blackSet.contains(new Position(j, i))) {
                    sb.append('X');
                } else sb.append('_');
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = new LangtonsAnt().printKMoves(20);
        for (String string : result)
            System.out.println(string);
    }

}
