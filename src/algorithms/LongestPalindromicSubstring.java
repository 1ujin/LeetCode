package algorithms;

public class LongestPalindromicSubstring {
    
    // method 1 ����ִ�к�LeetCodeִ�н����ͬ
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() == 2 && s.charAt(0) != s.charAt(1)) return s.substring(0, 1);
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
        
        // method 1.1
        for (int i = maxPos - maxLen + 1; i <= maxPos + maxLen - 1; i += 2) {
            result.append(chars[i]);
        }
        return result.toString();
        
        // method 1.2
        // return s.substring(maxPos / 2 - maxLen / 2, (maxPos + maxLen) / 2);
    }
    
    private static int getPalindromeLength(char[] chars, int pos) {
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
    
    // method 2
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
    
    // method 3
    public static String longestPalindrome3(String s) {
        if (s == null || s.length() < 2) return s;

        int[] rang = new int[2];
        char[] cs = s.toCharArray();
    
        for (int i = 0; i < cs.length; i++) {
            // �ѻ��Ŀ����м䲿�ֶ���ͬһ�ַ������ҶԳƣ�Ѱ����һ���뵱ǰ�ַ���ͬ��λ��
            i = fastMove(cs, i, rang);
            // ��ʣ�೤�Ȳ�����֪��󳤶ȵ�һ��ʱ
            if ((cs.length - i) * 2 < (rang[1] - rang[0] + 1)) {
                break;
            }
        }
    
        return s.substring(rang[0], rang[1] + 1);
    }
    
    private static int fastMove(char[] cs, int low, int[] rang) {
        int high = low;
        int len = cs.length;
    
        while (high < len - 1 && cs[high + 1] == cs[low]) {
            high++;
        }
        int nextI = high;
    
        while (low > 0 && high < len - 1 && cs[low - 1] == cs[high + 1]) {
            low--;
            high++;
    
        }
        if (high - low > rang[1] - rang[0]) {
            rang[0] = low;
            rang[1] = high;
        }
        return nextI;
    }
    
    // method 4 fastest
    public static String longestPalindrome4(String s) {
        if (s == null || s.length() == 0) return "";
      
        int sLength = s.length();
        
        if (sLength == 1) return s;

        char[] chars = s.toCharArray();

        int[] result = new int[2];
        for (int i = 0; i < sLength; i++) {
        	i = explore(chars, i, result);          
        }
        return s.substring(result[0] + 1, result[1]);
    }

    private static int explore(char[] chars, int i ,int[] result) {
        int l = i, r = i, length = chars.length;
        while ((r + 1) < length && chars[r + 1] == chars[r]) {
            r++;
        }
        int re = r;
        while (l >= 0 && r < length && chars[l] == chars[r]) {
            l--;
            r++;
        }
        // �Ƚϳ���
        if ((r - l) > (result[1] - result[0])) {
	        result[0] = l;
	        result[1] = r;
        }
        return re;
    }
    
    // method 5 dynamic programming
    public static String longestPalindrome5(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        // ��ά���鱣�������ַ���״̬
        boolean[][] dp = new boolean[len][len];
        // abcdedcba
        //   l   r
        // ��� dp[l, r] = true ��ô dp[l + 1, r - 1] Ҳһ��Ϊ true
        // �ؼ������[l + 1, r - 1] һ�������� 2 ��Ԫ�ز����жϵı�Ҫ
        // ��Ϊ��� [l + 1, r - 1] ֻ��һ��Ԫ�أ������жϣ�һ���ǻ��Ĵ�
        // ��� [l + 1, r - 1] ��ʾ������Ϊ�գ������жϣ�Ҳһ���ǻ��Ĵ�
        // [l + 1, r - 1] һ�������� 2 ��Ԫ�� �ȼ��� l + 1 < r - 1���� r - l >  2

        // д�����ʱ������д����� [l + 1, r - 1]  ��Ԫ��С�ڵ��� 1 ������ r - l <=  2 ���Ͳ������ж���

        // ��Ϊֻ�� 1 ���ַ���������ʼ�����ж�
        // ��߽�һ��Ҫ���ұ߽�С������ұ߽�� 1 ��ʼ
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                // ����Ӧ�������Ŵ�
                // ״̬ת�Ʒ��̣����ͷβ�ַ���Ȳ����м�Ҳ�ǻ���
                // ��ͷβ�ַ���ȵ�ǰ���£���������Ժ󲻹������䣨���ֻ�� 1 ��Ԫ�أ���ֱ�ӷ��� True ����
                // ����Ҫ�����������Ժ������Ļ�����
                // �ص���� or �Ķ�·���������������
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > longestPalindrome) {
                        longestPalindrome = r - l + 1;
                        longestPalindromeStr = s.substring(l, r + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }
    
    // method 6 recursion ����ʱ�����Ʊ�����������
    public static String longestPalindrome6(String s) {
    	if (s == null || s.length() == 0) return "";
    	int[] result = new int[2];
    	char[] chars = s.toCharArray();
    	for (int r = 1; r < s.length(); r++) {
			for (int l = 0; l < r; l++) {
				if (recursive(chars, l, r) && result[1] - result[0] < r - l) {
					result[0] = l;
					result[1] = r;
				}
			}
			
		}
    	return s.substring(result[0], result[1] + 1);
    }
    
    private static boolean recursive(char[] chars, int l, int r) {
    	if (l == r) return true;
    	if (chars[l] == chars[r]) {
    		if (r == l + 1) return true;
			l++;
			r--;
			return recursive(chars, l, r);
		}
		return false;
	}

    public static void main(String[] args) {
        System.out.println(longestPalindrome6("babab"));
    }

}
