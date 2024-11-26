package huawei;

import java.util.*;

/**
 * 跳房子 I
 */
public class OD179 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] steps = Arrays.stream(scanner.nextLine().split("[\\[\\],]")).filter(a -> !a.isBlank()).mapToInt(Integer::valueOf).toArray();
        int count = scanner.nextInt();
        scanner.close();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < steps.length - 1; i++)
            for (int j = i + 1; j < steps.length; j++)
                if (count == steps[i] + steps[j])
                    list.add(new int[]{i, j});
        list.sort(Comparator.comparingInt(a -> a[0] + a[1]));
        int[] min = list.get(0);
        System.out.println(Arrays.toString(new int[]{steps[min[0]], steps[min[1]]}));
    }
}
