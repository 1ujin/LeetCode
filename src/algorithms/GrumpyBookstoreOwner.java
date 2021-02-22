package algorithms;

public class GrumpyBookstoreOwner {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0, max = 0, curr = 0, len = customers.length;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
                customers[i] = 0;
            }
        }
        for (int i = 0; i < X; i++)
            curr += customers[i];
        max = curr;
        for (int i = 0; i < len - X; i++) {
            curr -= customers[i];
            curr += customers[i + X];
            max = Math.max(max, curr);
        }
        return max + sum;
    }

    public static void main(String[] args) {
        int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 };
        int[] grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        System.out.println(new GrumpyBookstoreOwner().maxSatisfied(customers, grumpy, 3));
    }

}
