package algorithms;

public class LongestCommonPrefix {
    
    // method 1
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length < 1) return "";
        if (strs.length == 1) return strs[0];
        StringBuffer result = new StringBuffer("");
        String preStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result.setLength(0);
            String str = strs[i];
            int minLength = Math.min(preStr.length(), str.length());
            for (int j = 0; j < minLength; j++) {
                if (preStr.charAt(j) == str.charAt(j)) {
                    result.append(preStr.charAt(j));
                } else break;
            }
            preStr = result.toString();
        }
        return result.toString();
    }
    
    // method 2
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        // 先找到最短的字符串来作为第一个，速度会更快
        for (int i = 1; i < strs.length; i++)
           while (strs[i].indexOf(prefix) != 0) {
               // 无法匹配就缩短prefix并重新尝试
               prefix = prefix.substring(0, prefix.length() - 1);
               if (prefix.isEmpty()) return "";
           }        
        return prefix;
    }
    
    // method 3
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            // 选一个字符并在后续数组成员中遍历匹配
            for (int j = 1; j < strs.length; j ++) {
                // 匹配则继续循环，否则直接跳出并返回当前已匹配的结果
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);             
            }
        }
        // 全部都匹配
        return strs[0];
    }
    
    // method 4 divide-and-conquer
    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) return "";    
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    // divide 分
    private static String longestCommonPrefix(String[] strs, int l, int r) {
        // 不能再分
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r)/2;
            // 递归调用
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            // 处理两个分支的结果并返回给上一个lcpLeft或lcpRight
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    // conquer 治 相当于 method 2
    private static String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());       
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
    
    // method 5 binary search
    public static String longestCommonPrefix5(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int high = Integer.MAX_VALUE;
        // 获取最短字符串的长度
        for (String str : strs)
        	high = Math.min(high, str.length());
        int low = 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
            	// 所有字符串全部匹配则在右半区重新选择左指针
                low = middle + 1;
            else
            	// 否则在左半区重新选择右指针
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
        	// startWith检测字符串是否以指定的前缀开始
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
    
    // method 6 fastest
    public static String longestCommonPrefix6(String[] strs) {
        if (strs.length == 0) return "";
        String res = "";
        boolean tag = false;
        int min_len = Integer.MAX_VALUE;
        for (String str: strs)
        	min_len = Math.min(min_len, str.length());
        for (int i = min_len - 1; i > -1; i--) {
            tag = true;
            // 取最短的字符串去匹配所有字符串，不匹配则将末位提前
            String tmp = strs[0].substring(0, i + 1);
            for (String str : strs) {
                if (!str.startsWith(tmp)) {
                    tag = false;
                    break;
                }
            }
            if (!tag) continue;
            res = tmp;
            break;
        }
        return res;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        longestCommonPrefix6(new String[] {"flower", "flow", "flight"});
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");
        
    }

}
