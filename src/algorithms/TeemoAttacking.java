package algorithms;

public class TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            int interval = timeSeries[i] - timeSeries[i - 1];
            total += Math.min(interval, duration);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] timeSeries = { 1, 4 };
        System.out.println(new TeemoAttacking().findPoisonedDuration(timeSeries, 2));
    }

}
