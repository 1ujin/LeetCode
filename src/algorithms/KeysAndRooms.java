package algorithms;

import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {
    
    boolean[] keys;
    List<List<Integer>> rooms;
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        int len = rooms.size();
        keys = new boolean[len];
        keys[0] = true;
        dfs(rooms.get(0));
        for (boolean key : keys)
            if (!key) return false;
        return true;
    }

    private void dfs(List<Integer> room) {
        if (room.isEmpty()) return;
        for (Integer key : room) {
            if (!this.keys[key]) {
                keys[key] = true;
                dfs(this.rooms.get(key));
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(3, 0, 1),
                Arrays.asList(2),
                Arrays.asList(0));
        System.out.println(new KeysAndRooms().canVisitAllRooms(rooms)); // false
    }

}
