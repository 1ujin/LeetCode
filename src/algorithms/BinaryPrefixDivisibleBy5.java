package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();
        int pre = 0;
        for (int a : A)
            list.add((pre = ((pre << 1) + a) % 5) == 0);
        return list;
    }

    public static void main(String[] args) {
        int[] A = { 0, 1, 1, 1, 1, 1 };
        System.out.println(new BinaryPrefixDivisibleBy5().prefixesDivBy5(A));
    }

}
