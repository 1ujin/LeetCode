package algorithms;

public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int D) {
        int sum = 0, max = 0, min = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
            min = Math.min(min, weight);
            sum += weight;
        }
        int lo = max, hi = sum - (D - 1) * min;
        while (lo < hi) {
            int cap = lo + hi >> 1;
            if (canShip(weights, cap, D))
                hi = cap;
            else lo = cap + 1;
        }
        return hi;
    }

    private boolean canShip(int[] weights, int cap, int D) {
        int d = 0;
        for (int i = 0, sum = 0; i < weights.length && d <= D; sum = 0, d++)
            while (i < weights.length && sum + weights[i] <= cap)
                sum += weights[i++];
        return d <= D;
    } 

    public static void main(String[] args) {
        int[] weights = { 3, 2, 2, 4, 1, 4 };
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays(weights, 3));
    }

}
