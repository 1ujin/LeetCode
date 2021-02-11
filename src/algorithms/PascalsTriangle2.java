package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

    // method 1
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < i; j++)
                temp.add(list.get(j) + list.get(j + 1));
            temp.add(1);
            list = temp;
        }
        return list;
    }

    // method 2
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--)
                list.set(j, list.get(j) + list.get(j - 1));
            list.add(1);
        }
        return list;
    }

    // method 3 fastest
    public List<Integer> getRow3(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i++)
            list.add((int) ((long) list.get(i - 1) * (rowIndex - i + 1) / i));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle2().getRow3(3));
    }

}
