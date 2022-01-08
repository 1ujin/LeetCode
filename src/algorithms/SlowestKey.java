package algorithms;

public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] cs = keysPressed.toCharArray();
        char slowestKey = cs[0];
        int n = releaseTimes.length;
        for (int i = 1, maxTime = releaseTimes[0]; i < n; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > maxTime || time == maxTime && cs[i] > slowestKey) {
                maxTime = time;
                slowestKey = cs[i];
            }
        }
        return slowestKey;
    }

    public static void main(String[] args) {
        int[] releaseTimes = { 12, 23, 36, 46, 62 };
        System.out.println(new SlowestKey().slowestKey(releaseTimes, "spuda"));
    }

}
