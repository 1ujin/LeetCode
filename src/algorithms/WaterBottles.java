package algorithms;

public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int full = numBottles, empty = 0, sum = 0;
        while (full > 0) {
            sum += full;
            empty += full;
            full = empty / numExchange;
            empty %= numExchange;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new WaterBottles().numWaterBottles(15, 4));
    }

}
