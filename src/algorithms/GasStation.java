package algorithms;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, tmp = 0, begin = 0;
        for (int i = 0; i < gas.length; i++) {
            tmp += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (tmp < 0) {
                begin = i + 1;
                tmp = 0;
            }
        }
        return sum < 0 ? -1 : begin;
    }

    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4, 5 }, cost = { 3, 4, 5, 1, 2 };
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }

}
