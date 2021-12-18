package algorithms;

public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {
        int[] a = new int[n], b = new int[n];
        for (int[] t : trust) {
            a[t[0] - 1]++;
            b[t[1] - 1]++;
        }
        for (int i = 0; i < n; i++)
            if (a[i] == 0 && b[i] == n - 1)
                return i + 1;
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
        System.out.println(new FindTheTownJudge().findJudge(4, trust));
    }

}
