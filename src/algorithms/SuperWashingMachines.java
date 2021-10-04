package algorithms;

public class SuperWashingMachines {

    public int findMinMoves(int[] machines) {
        int sum = 0, len = machines.length;
        for (int machine : machines)
            sum += machine;
        if (sum % len != 0)
            return -1;
        int avg = sum / len, move = 0, preSum = 0;
        for (int machine : machines) {
            int diff = machine - avg;
            preSum += diff;
            move = Math.max(move, Math.max(diff, Math.abs(preSum)));
        }
        return move;
    }

    public static void main(String[] args) {
        int[] machines = { 0, 0, 11, 5 };
        System.out.println(new SuperWashingMachines().findMinMoves(machines));
    }

}
