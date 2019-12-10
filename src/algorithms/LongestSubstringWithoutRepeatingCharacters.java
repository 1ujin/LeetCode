package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	
	// method 1
	public static int lengthOfLongestSubstring1(String s) {
		char[] chars = s.toCharArray();
		ArrayList<Character> repeat;
		int maxLen = 0, head = 0, c = 0;
		for (head = 0; head < chars.length; head++) {
			repeat = new ArrayList<Character>();
			for (c = head + 1; c < chars.length; c++) {
				if (chars[c] != chars[head]) {
					if (repeat.indexOf(chars[c]) > -1) {
						break;
					} else {
						repeat.add(chars[c]);
					}
				}
				
				if (chars[c] == chars[head]) break;
			}
			if (c - head > maxLen) maxLen = c - head;
		}
		return maxLen;
	}
	
	// method 2
	public static int lengthOfLongestSubstring2(String s) {
		int maxLength=0;
        int indexOf=0;
        char[] chars = s.toCharArray();

        for(int i=0;i<chars.length;i++){
            for(int j=indexOf;j<i;j++){

                if(chars[j] == chars[i]){
                    maxLength=Math.max(maxLength,i-indexOf);
                    indexOf=j+1;
                    break;
                }
            }
        }
        return Math.max(maxLength,chars.length-indexOf);
	}
	
	// method 3
	public static int lengthOfLongestSubstring3(String s) {
		int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.print(lengthOfLongestSubstring3("xxzqi"));
	}

}
