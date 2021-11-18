package algorithms;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {

    private Map<Integer, Integer> map = new HashMap<>();

    public int integerReplacement(int n) {
        if (n == 1)
            return 0;
        if (!map.containsKey(n)) {
            if (n % 2 == 0)
                map.put(n, 1 + integerReplacement(n >> 1));
            else
                map.put(n, 2 + Math.min(integerReplacement(n >> 1),
                        integerReplacement((n >> 1) + 1)));
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new IntegerReplacement().integerReplacement(-1 >>> 1));
    }

}
