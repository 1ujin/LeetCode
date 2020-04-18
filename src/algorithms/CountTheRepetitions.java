package algorithms;

public class CountTheRepetitions {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (s1.length() == 0 || s2.length() == 0 || n1 == 0 || n2 == 0)
            return 0;
        char[] s1Chars = s1.toCharArray(), s2Chars = s2.toCharArray();
        int count = 0, index = 0;
        // 存储在每个s1字符串中可以匹配出的s2字符串的索引
        int[] indexr = new int[s2Chars.length + 1];
        // 存储在每个s1字符串时匹配出的s2字符串的个数，可能是包含了前面一个s1循环节的部分
        int[] countr = new int[s2Chars.length + 1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < s1Chars.length; j++) {
                if (s1Chars[j] == s2Chars[index]) {
                    if (index == s2Chars.length - 1) {
                        count++;
                        index = 0;
                    } else index++;
                }
            }
            countr[i] = count;
            indexr[i] = index;
            // 剪枝，跳出循环的判断
            // 从计数的数组里面去找是否已经出现过该索引。
            // 意味着已经出现重复的循环节了。就可以直接计算了。
            if (i > 0 && indexr[0] == index) {
                int prev_count = countr[0];
                int pattern_count = ((n1 - 1) / i) * (countr[i] - countr[0]);
                int remain_count = countr[(n1 - 1) % i] - countr[0];
                return (prev_count + pattern_count + remain_count) / n2;
            }
        }
        return countr[n1 - 1] / n2;
    }

    public static void main(String[] args) {
        System.out.println(new CountTheRepetitions().getMaxRepetitions("acb", 4, "ab", 2));
    }

}
