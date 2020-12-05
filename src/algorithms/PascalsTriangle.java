package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) return lists;
        List<Integer> list = new ArrayList<>(), temp = null;
        list.add(1);
        lists.add(list);
        for (int numRow = 2; numRow <= numRows; numRow++) {
            temp = list;
            list = new ArrayList<>();
            list.add(1);
            for (int i = 0; i < numRow - 2; i++)
                list.add(temp.get(i) + temp.get(i + 1));
            list.add(1);
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(5));
    }

}
