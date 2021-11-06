package algorithms;

public class RangeAddition2 {

    public int maxCount(int m, int n, int[][] ops) {
        int a = m, b = n;
        for (int[] op : ops) {
            a = Math.min(a, op[0]);
            b = Math.min(b, op[1]);
        }
        return a * b;
    }

    public static void main(String[] args) {
        int[][] ops = { { 2, 2 }, { 3, 3 } };
        System.out.println(new RangeAddition2().maxCount(3, 3, ops));
    }

}
