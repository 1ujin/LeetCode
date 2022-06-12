package algorithms;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] counts = new int[101];
        for (int height : heights)
            counts[height]++;
        int res = 0, idx = 0;
        for (int i = 1; i <= 100; i++)
            for (int j = 0; j < counts[i]; j++, idx++)
                if (heights[idx] != i)
                    res++;
        return res;
    }

    public static void main(String[] args) {
        int[] heights = { 1, 1, 4, 2, 1, 3 };
        System.out.println(new HeightChecker().heightChecker(heights));
    }

}
