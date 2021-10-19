package algorithms;

public class MinimumMovesToEqualArrayElements {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, move = 0;
        for (int num : nums)
            min = Math.min(min, num);
        for (int num : nums)
            move += num - min;
        return move;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1000000000 };
        System.out.println(new MinimumMovesToEqualArrayElements().minMoves(nums));
    }

}
