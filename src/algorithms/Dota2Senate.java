package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiants = new LinkedList<>(), dires = new LinkedList<>();
        int len = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'R') radiants.offer(len++);
            else dires.offer(len++);
        }
        while (!radiants.isEmpty() && !dires.isEmpty()) {
            int r = radiants.poll(), d = dires.poll();
            if (r < d) radiants.offer(r + len);
            else dires.offer(d + len);
        }
        return radiants.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        System.out.println(new Dota2Senate().predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }

}
