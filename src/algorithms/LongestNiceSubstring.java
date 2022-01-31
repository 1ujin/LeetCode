package algorithms;

public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        String result = "";
        for (int i = 0; i < len; i++) {
            int upper = 0, lower = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < len; j++) {
                sb.append(cs[j]);
                if (cs[j] <= 'Z')
                    upper |= 1 << cs[j] - 'A';
                else if (cs[j] >= 'a')
                    lower |= 1 << cs[j] - 'a';
                if (upper == lower && sb.length() > result.length())
                    result = sb.toString();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestNiceSubstring().longestNiceSubstring("YazaAay"));
    }

}
