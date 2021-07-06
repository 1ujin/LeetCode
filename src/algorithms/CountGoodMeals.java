package algorithms;

public class CountGoodMeals {

    public int countPairs(int[] deliciousness) {
        long count = 0;
        int max = 0, min = Integer.MAX_VALUE;
        for (int d : deliciousness) {
            max = d > max ? d : max;
            min = d < min ? d : min;
        }
        int[] counts = new int[max - min + 1];
        for (int d : deliciousness) {
            for (int sum = 1;; sum <<= 1) {
                int diff = sum - d;
                if (diff < min)
                    continue;
                if (diff > max)
                    break;
                count += counts[diff - min];
            }
            counts[d - min]++;
        }
        return (int) (count % 1000000007);
    }

    public static void main(String[] args) {
        int[] deliciousness = { 1, 1, 1, 3, 3, 3, 7 };
        System.out.println(new CountGoodMeals().countPairs(deliciousness));
    }

}
