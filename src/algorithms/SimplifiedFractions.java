package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions {

    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for (int b = 2; b <= n; b++)
            for (int a = 1; a < b; a++)
                if (gcd(a, b) == 1)
                    list.add(a + "/" + b);
        return list;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(new SimplifiedFractions().simplifiedFractions(4));
    }

}
