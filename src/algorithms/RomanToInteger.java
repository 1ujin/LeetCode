package algorithms;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    
    // method 1
    public static int romanToInt1(String s) {
    	int num = 0;
    	Map<String, Integer> map = new HashMap<>();
    	map.put("M", 1000);
    	map.put("CM", 900);
    	map.put("D", 500);
    	map.put("CD", 400);
    	map.put("C", 100);
    	map.put("XC", 90);
    	map.put("L", 50);
    	map.put("XL", 40);
    	map.put("X", 10);
    	map.put("IX", 9);
    	map.put("V", 5);
    	map.put("IV", 4);
    	map.put("I", 1);
    	for (int i = 0; i < s.length(); i++) {
    		String key = "";
			if (i < s.length() - 1) {
				key = s.substring(i, i + 2);
				if (map.containsKey(key) == false) key = s.substring(i, i + 1);
				else i++;
			} else {
				key = s.substring(i, i + 1);
			}
			num += map.get(key);
		}
        return num;
    }
    
    // method 2 fastest
    public static int romanToInt2(String s) {
    	int sum = 0, preNum = getValue(s.charAt(0));
    	// 若字符串长度为1则直接跳过循环
        for(int i = 1; i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
            	// 前小后大说明前者为负值
                sum -= preNum;
            } else {
            	// 前大后小说明前者为正值
                sum += preNum;
            }
            // 更新前一个值
            preNum = num;
        }
        // 最后一位恒为正
        sum += preNum;
        return sum;
    }
    
    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
	}

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        romanToInt2("MMMCMXCIXI");
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
