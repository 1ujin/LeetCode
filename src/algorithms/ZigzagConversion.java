package algorithms;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversion {
	
	// method 1
	public static String convert1(String s, int numRows) {
		if (numRows == 1) return s;
		List<StringBuilder> rows = new ArrayList<StringBuilder>();
		for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
		for (int i = 0; i < s.length(); i++) {
			int remainder = i % ((numRows - 1) * 2);
			if (remainder < numRows) {
				rows.get(remainder).append(s.charAt(i));
			} else {
				rows.get(2 * (numRows - 1) - remainder).append(s.charAt(i));
			}
		}
		String ret = "";
        for (StringBuilder row : rows) ret += row.toString();
        return ret;
	}
	
	// method 2 fastest
	public static String convert2(String s, int numRows) {
		if (numRows == 1) return s;
        int round = (numRows << 1) - 2;
        char[] arr = s.toCharArray();
        char[] res = new char[arr.length];
        int cur = 0;
        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < arr.length; j += round ) {
                res[cur++] = arr[j];
                if(i > 0 && i < numRows - 1 && j + round - i * 2 < arr.length) {
                    res[cur++] = arr[j + round - i * 2 ];
                }
            }
        }

        return new String(res);
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(convert2("PAYPALISHIRING", 3));
        long endTime = System.nanoTime();
        System.out.println("Duration: " + (endTime - startTime) + "ns");
	}

}
