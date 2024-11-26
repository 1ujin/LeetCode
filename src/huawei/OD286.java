package huawei;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 数组拼接
 */
public class OD286 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mod = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] arrays = new int[n][];
        int len = 0;
        for (int i = 0; i < n; i++) {
            arrays[i] = Arrays.stream(scanner.nextLine().split(",")).filter(a -> !a.isBlank()).mapToInt(Integer::valueOf).toArray();
            len += arrays[i].length;
        }
        scanner.close();
        int[] merge = new int[len];
        int[] idx = new int[n];
        for (int i = 0; i < merge.length;) {
            for (int j = 0; j < idx.length; j++) {
                int[] arr = arrays[j];
                for (int k = idx[j]; idx[j] - k < mod && idx[j] < arr.length; )
                    merge[i++] = arr[idx[j]++];
            }
        }
        StringJoiner sj = new StringJoiner(",");
        for (int num : merge)
            sj.add(String.valueOf(num));
        System.out.println(sj);
    }
}
