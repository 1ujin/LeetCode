package lcof;

import java.util.Arrays;

public class Solution45 {

    public String minNumber(int[] nums) {
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, (a, b) -> {
            int x = 10, y = 10;
            while (x <= a) x *= 10;
            while (y <= b) y *= 10;
            return a * y + b - b * x - a;
        });
        StringBuilder sb = new StringBuilder();
        Arrays.stream(integers).forEach(i -> sb.append(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = { 824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247 };
        System.out.println(new Solution45().minNumber(nums));
    }

}
