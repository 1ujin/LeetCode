package lcci;

import java.util.ArrayList;
import java.util.List;

public class EnglishInt {
    
    private final String[] num9  = {"", "One", "Two", "Three", "Four","Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] num19 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] num90 = {"", "", "Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] scale = {"", "Thousand", "Million", "Billion"};            
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        List<String> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int sign = num > 0 ? 1 : -1;
        num = sign * num;
        while (num > 0) {
            list.add(num % 1000);
            num /= 1000;
        }
        String tmp = tripleDigits(list.get(0));
        if (tmp != null) result.add(tmp);
        for (int i = 1; i < list.size(); i++) {
            tmp = tripleDigits(list.get(i));
            if (tmp == null) continue;
            result.add(0, scale[i]);
            result.add(0, tmp);
        }
        if (sign == -1) result.add(0, "Negative");
        return String.join(" ", result);
    }
    
    private String tripleDigits(int num) {
        if (num == 0) return null;
        List<String> list = new ArrayList<>();
        if (num / 100 > 0) list.add(num9[num / 100] + " " + "Hundred");
        num %= 100;
        if (num > 19) {
            list.add(num90[num / 10]);
            num %= 10;
        } else if (num > 9) {
            list.add(num19[num % 10]);
            num = 0;
        }
        if (num > 0) list.add(num9[num]);
        return String.join(" ", list);
    }

    public static void main(String[] args) {
        System.out.println(new EnglishInt().numberToWords(-Integer.MAX_VALUE));
    }

}
