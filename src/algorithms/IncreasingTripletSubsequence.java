package algorithms;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int third : nums) {
            if (third <= first)
                first = third;
            else if (third <= second)
                second = third;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 5, 0, 4, 6 };
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(nums));
    }

}
