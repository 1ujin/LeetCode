package lcci;

public class StringToUrl {
    
    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        int j = S.length() - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                // 不用交换字符与空格，直接覆盖字符串尾的空间，j 永远追不上 i
                chars[j--] = chars[i];
            } else {
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            }
        }
        return String.valueOf(chars, j + 1, S.length() - j - 1);
    }

    public static void main(String[] args) {
        StringToUrl solution = new StringToUrl();
        long startTime = System.nanoTime();
        String result = solution.replaceSpaces("ds sdfs afs sdfa dfssf asdf             ", 27);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
