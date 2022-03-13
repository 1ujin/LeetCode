package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        int min = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            if (map.containsKey(s)) {
                int val = map.get(s) + i;
                if (val < min) {
                    min = val;
                    list.clear();
                }
                if (val == min)
                    list.add(s);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] list2 = { "Piatti", "The Grill at Torrey Pines",
                "Hungry Hunter Steakhouse", "Shogun" };
        System.out.println(Arrays.toString(new MinimumIndexSumOfTwoLists()
                .findRestaurant(list1, list2)));
    }

}
