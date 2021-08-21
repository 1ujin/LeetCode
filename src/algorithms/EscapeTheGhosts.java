package algorithms;

public class EscapeTheGhosts {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts)
            if (Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]) <= distance)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] ghosts = { { 1, 9 }, { 2, -5 }, { 3, 8 }, { 9, 8 }, { -1, 3 } };
        int[] target = { 8, -10 };
        System.out.println(new EscapeTheGhosts().escapeGhosts(ghosts, target));
    }

}
