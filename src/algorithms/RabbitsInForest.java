package algorithms;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    
    // method 1
    public int numRabbits1(int[] answers) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers)
            map.compute(answer, (k, v) -> v == null ? 1 : ++v);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            sum += ((value - 1) / (key + 1) + 1) * (key + 1);
        }
        return sum;
    }
    
    // method 2 fastest
    public int numRabbits2(int[] answers) {
        int sum = 0;
        int[] count = new int[1000];
        for (int answer : answers)
            count[answer]++;
        for (int i = 0; i < 1000; i++)
            if (count[i] != 0)
                sum += ((count[i] - 1) / (i + 1) + 1) * (i + 1);
        return sum;
    }

    public static void main(String[] args) {
        int[] answers = { 1, 1, 2 };
        System.out.println(new RabbitsInForest().numRabbits2(answers));
    }

}
