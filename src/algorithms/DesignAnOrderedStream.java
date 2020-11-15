package algorithms;

import java.util.ArrayList;
import java.util.List;

class OrderedStream {
    
    int ptr = 0;
    String[] strs;

    public OrderedStream(int n) {
        strs = new String[n];
    }
    
    public List<String> insert(int id, String value) {
        strs[id - 1] = value;
        List<String> list = new ArrayList<>();
        while (ptr < strs.length) {
            if (strs[ptr] != null)
                list.add(strs[ptr]);
            else break;
            ptr++;
        }
        return list;
    }
}

public class DesignAnOrderedStream {

    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc"));
        System.out.println(os.insert(1, "aaaaa"));
        System.out.println(os.insert(2, "bbbbb"));
        System.out.println(os.insert(5, "eeeee"));
        System.out.println(os.insert(4, "ddddd"));
    }

}
