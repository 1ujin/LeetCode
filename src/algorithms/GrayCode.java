package algorithms;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1, len = 1; i <= n; i++, len <<= 1)
            for (int j = len - 1; j >= 0; j--)
                list.add(list.get(j) | (1 << (i - 1)));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(3));
    }

}
