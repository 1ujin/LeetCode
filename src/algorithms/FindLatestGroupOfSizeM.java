package algorithms;

public class FindLatestGroupOfSizeM {
    
    public int findLatestStep(int[] arr, int m) {
        // 第 i 到 dp[i] 个数字为连续的 1，即 i 与 dp[i] 为当前连续数字 1 的两个端点
        int[] dp = new int[arr.length + 2];
        int count = 0, step = -1;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int left = dp[a - 1] == 0 ? a : dp[a - 1];
            int right = dp[a + 1] == 0 ? a : dp[a + 1];
            if (a - left == m)
                count--;
            if (right - a == m)
                count--;
            if (right - left + 1 == m)
                count++;
            if (count > 0)
                step = i + 1;
            dp[left] = right;
            dp[right] = left;
        }
        return step;
    }

    public static void main(String[] args) {
        int[] arr = { 77, 59, 78, 15, 96, 54, 22, 57, 49, 27, 8, 95, 32, 83, 68,
                31, 60, 51, 11, 66, 13, 94, 91, 81, 17, 72, 4, 71, 42, 33, 10,
                90, 73, 67, 38, 40, 39, 36, 63, 58, 3, 76, 50, 23, 55, 37, 70,
                85, 80, 2, 86, 84, 41, 35, 34, 25, 69, 53, 74, 5, 75, 89, 93,
                62, 47, 44, 24, 9, 29, 28, 48, 46, 82, 56, 21, 43, 64, 6, 79,
                19, 65, 16, 30, 92, 45, 87, 14, 18, 52, 61, 88, 26, 7, 12, 20,
                1 };
        System.out.println(new FindLatestGroupOfSizeM().findLatestStep(arr, 7));
    }

}
