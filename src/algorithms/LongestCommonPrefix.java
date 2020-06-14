package algorithms;

public class LongestCommonPrefix {
    
    // method 1
    public static String longestCommonPrefix1(String[] strs) {
        int len = strs.length;
        if (len == 0) return "";
        if (len == 1) return strs[0];
        StringBuilder result = new StringBuilder("");
        char[] preStr = strs[0].toCharArray();
        for (int i = 1; i < len; i++) {
            result.setLength(0);
            String str = strs[i];
            int minLength = Math.min(preStr.length, str.length());
            for (int j = 0; j < minLength; j++)
                if (preStr[j] == str.charAt(j))
                    result.append(preStr[j]);
                else break;
            preStr = result.toString().toCharArray();
        }
        return result.toString();
    }
    
    // method 2
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        // ���ҵ���̵��ַ�������Ϊ��һ�����ٶȻ����
        for (int i = 1; i < strs.length; i++)
           while (strs[i].indexOf(prefix) != 0) {
               // �޷�ƥ�������prefix�����³���
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
            // ѡһ���ַ����ں��������Ա�б���ƥ��
            for (int j = 1; j < strs.length; j ++) {
                // ƥ�������ѭ��������ֱ�����������ص�ǰ��ƥ��Ľ��
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);             
            }
        }
        // ȫ����ƥ��
        return strs[0];
    }
    
    // method 4 divide-and-conquer
    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) return "";    
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    // divide ��
    private static String longestCommonPrefix(String[] strs, int l, int r) {
        // �����ٷ�
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r)/2;
            // �ݹ����
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            // ����������֧�Ľ�������ظ���һ��lcpLeft��lcpRight
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    // conquer �� �൱�� method 2
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
        // ��ȡ����ַ����ĳ���
        for (String str : strs)
        	high = Math.min(high, str.length());
        int low = 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
            	// �����ַ���ȫ��ƥ�������Ұ�������ѡ����ָ��
                low = middle + 1;
            else
            	// ���������������ѡ����ָ��
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
        	// startWith����ַ����Ƿ���ָ����ǰ׺��ʼ
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
            // ȡ��̵��ַ���ȥƥ�������ַ�������ƥ����ĩλ��ǰ
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
