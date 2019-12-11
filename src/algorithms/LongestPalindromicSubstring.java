package algorithms;

public class LongestPalindromicSubstring {
	
	// method 1 ����ִ�к�LeetCodeִ�н����ͬ
	public static String longestPalindrome1(String s) {
		if (s == null || s.length() == 0) return "";
		// �������Ӵ�������LeetCode�ύ��ȷ
		if (s.length() == 1) return s;
		StringBuffer stringBuffer = new StringBuffer(), result = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			stringBuffer.append("#");
			stringBuffer.append(s.charAt(i));
		}
		stringBuffer.append("#");
		char[] chars = stringBuffer.toString().toCharArray();
		int maxLen = 0, newLen = 0, maxPos = 0;
		for (int i = 0; i < chars.length; i++) {
			newLen = getPalindromeLength(chars, i);
			if (newLen > maxLen) {
				maxLen = newLen;
				maxPos = i;
			}
		}
		// ע�ͺ󲻷����Ӵ�������LeetCode�ύ��ȷ
		/*if (2 * maxLen + 1 == chars.length && chars.length > 5) {
			maxLen -= 2;
		}*/
		for (int i = maxPos - maxLen + 1; i <= maxPos + maxLen - 1; i += 2) {
			result.append(chars[i]);
		}
		return result.toString();
    }
	
	public static int getPalindromeLength(char[] chars, int pos) {
		int len = 0;
		for (int i = 0; i <= pos && i < (chars.length - pos); i++) {
			if (chars[pos - i] == chars[pos + i]) {
				len++;
			} else {
				break;
			}
		}
		return len - 1;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome1("babab"));
	}

}
