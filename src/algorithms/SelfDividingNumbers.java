package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            int divisor = num;
            for (; divisor > 0; divisor /= 10)
                if (divisor % 10 == 0 || num % (divisor % 10) != 0)
                    break;
            if (divisor == 0)
                list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new SelfDividingNumbers().selfDividingNumbers(1, 22));
    }

}
