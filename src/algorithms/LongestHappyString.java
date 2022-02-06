package algorithms;

import java.util.Arrays;

public class LongestHappyString {

    public String longestDiverseString(int a, int b, int c) {
        int[][] arr = new int[3][2];
        arr[0][0] = a;
        arr[0][1] = 'a';
        arr[1][0] = b;
        arr[1][1] = 'b';
        arr[2][0] = c;
        arr[2][1] = 'c';
        StringBuilder sb = new StringBuilder();
        boolean hasNext = true;
        while (hasNext) {
            hasNext = false;
            Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);
            for (int[] item : arr) {
                if (item[0] <= 0)
                    break;
                int len = sb.length();
                char ch = (char) item[1];
                if (len > 1 && sb.charAt(len - 2) == ch
                        && sb.charAt(len - 1) == ch)
                    continue;
                hasNext = true;
                sb.append(ch);
                item[0]--;
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongestHappyString().longestDiverseString(1, 1, 7));
    }

}
