package algorithms;

public class OptimalDivision {

    public String optimalDivision(int[] nums) {
        if (nums.length == 1)
            return String.valueOf(nums[0]);
        if (nums.length == 2)
            return String.format("%d/%d", nums[0], nums[1]);
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        sb.append("/(");
        sb.append(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            sb.append("/");
            sb.append(nums[i]);
        }
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = { 1000, 100, 10, 2 };
        System.out.println(new OptimalDivision().optimalDivision(nums));
    }

}
