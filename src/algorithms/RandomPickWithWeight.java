package algorithms;

public class RandomPickWithWeight {

    private int sum;
    private int[] w;

    public RandomPickWithWeight(int[] w) {
        this.w = w;
        for (int i = 1; i < w.length; i++)
            w[i] += w[i - 1];
        sum = w[w.length - 1];
    }

    public int pickIndex() {
        int rand = (int) (Math.random() * sum) + 1;
        int lo = 0, hi = w.length - 1;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (w[mid] < rand)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] w = { 1, 3 };
        RandomPickWithWeight solution = new RandomPickWithWeight(w);
        System.out.println(solution.pickIndex()); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
        System.out.println(solution.pickIndex()); // 返回 1
        System.out.println(solution.pickIndex()); // 返回 1
        System.out.println(solution.pickIndex()); // 返回 1
        System.out.println(solution.pickIndex()); // 返回 0，返回下标 0，返回该下标概率为 1/4 。
    }

}
