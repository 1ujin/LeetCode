package lcof;

public class Solution56II {

    public int singleNumber(int[] nums) {
        /*
         * +---------+----------+----------+
         * |         |  state2  |  state1  |
         * +---------+----------+----------+
         * |  0(00)  |       0  |       0  |
         * +---------+----------+----------+
         * |  1(01)  |       0  |       1  |
         * +---------+----------+----------+
         * |  2(10)  |       1  |       0  |
         * +---------+----------+----------+ 
         */
        int state1 = 0, state2 = 0;
        for (int i : nums) {
            state1 = state1 ^ i & ~state2;
            state2 = state2 ^ i & ~state1;
        }
        return state1;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 1, 7, 9, 7, 9, 7 };
        System.out.println(new Solution56II().singleNumber(nums));
    }

}
