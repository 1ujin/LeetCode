package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : hand)
            map.put(key, map.getOrDefault(key, 0) + 1);
        for (int key : hand) {
            if (!map.containsKey(key))
                continue;
            int count = map.get(key);
            for (int i = 0; i < groupSize; i++) {
                int current = key + i;
                if (!map.containsKey(current))
                    return false;
                else if (map.get(current) == count)
                    map.remove(current);
                else
                    map.put(current, map.get(current) - count);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        System.out.println(new HandOfStraights().isNStraightHand(hand, 3));
    }

}
