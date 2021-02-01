package algorithms;

public class LongestRepeatingCharacterReplacement {
    
    // method 1 slowest
    public int characterReplacement1(String s, int k) {
        char[] cs = s.toCharArray();
        if (cs.length < 1) return 0;
        int maxLen = 1;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            int t = k, currLen = 1;
            for (int j = i + 1; j < cs.length; j++) {
                if (cs[j] != c) {
                    if (t == k)
                        i = j - 1;
                    if (--t < 0)
                        break;
                }
                currLen++;
            }
            maxLen = Math.max(maxLen, Math.min(currLen + Math.max(0, t), cs.length));
        }
        return maxLen;
    }
    
    // method 2 fastest
    public int characterReplacement2(String s, int k) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        if (len < 2) return len;
        int[] freq = new int[26];
        int left = 0, right = 0, res = 1;
        // 滑动窗口 [left, right) 内出现字符最多的次数
        int maxCount = 0;
        while (right < len) {
            freq[cs[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[cs[right] - 'A']);
            right++;
            while (right - left > maxCount + k)
                freq[cs[left++] - 'A']--;
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement2("AABABBA", 1));
    }

}
