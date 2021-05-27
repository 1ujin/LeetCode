package algorithms;

public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int len = nums.length, sum = 0;
        for (int i = 0; i < 30; i++) {
            int oneCount = 0;
            for (int num : nums)
                oneCount += (num >>> i) & 1;
            sum += oneCount * (len - oneCount);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 14, 2 };
        System.out.println(new TotalHammingDistance().totalHammingDistance(nums));
    }

}
