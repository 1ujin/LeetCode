package algorithms;

public class PartitionArrayIntoThreePartsWithEqualSum {
    
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) sum += i;
        if (sum % 3 != 0) return false;
        int oneThird = 0, count = 0;
        for (int i : A) {
            oneThird += i;
            if (oneThird == sum / 3) {
                count++;
                oneThird = 0;
            }
        }
        return count >= 3;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        boolean result = new PartitionArrayIntoThreePartsWithEqualSum()
                .canThreePartsEqualSum(new int[] {18,12,-18,18,-19,-1,10,10});
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
