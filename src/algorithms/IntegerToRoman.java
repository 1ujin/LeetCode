package algorithms;

public class IntegerToRoman {
	
	// method 1
	public static String intToRoman1(int num) {
		if (num < 1 || num > 3999) return "";
		StringBuffer result = new StringBuffer("");
		for (int i = num / 1000; i > 0; i--) {
			result.append("M");
		}
		num %= 1000;
		if (num >= 900) {
			result.append("CM");
			num -= 900;
		} else if (num >= 500) {
			result.append("D");
			num -= 500;
		} else if (num >= 400) {
			result.append("CD");
			num -= 400;
		}
		for (int i = num / 100; i > 0; i--) {
			result.append("C");
		}
		num %= 100;
		if (num >= 90) {
			result.append("XC");
			num -= 90;
		} else if (num >= 50) {
			result.append("L");
			num -= 50;
		} else if (num >= 40) {
			result.append("XL");
			num -= 40;
		}
		for (int i = num / 10; i > 0; i--) {
			result.append("X");
		}
		num %= 10;
		if (num >= 9) {
			result.append("IX");
			num -= 9;
		} else if (num >= 5) {
			result.append("V");
			num -= 5;
		} else if (num >= 4) {
			result.append("IV");
			num -= 4;
		}
		for (int i = num; i > 0; i--) {
			result.append("I");
		}
		return result.toString();
	}
	
	// method 2 greedy algorithm
	public static String intToRoman2(int num) {
		if (num < 1 || num > 3999) return "";
		String[] key = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		int[] value = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		StringBuffer result = new StringBuffer("");
		int i = 0;
		while (num > 0) {
			while (num >= value[i]) {
				result.append(key[i]);
				num -= value[i];
			}
			i++;
		}
		return result.toString();
	}

    public static void main(String[] args) {
    	long startTime = System.nanoTime();
    	intToRoman1(3999);
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
