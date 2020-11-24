package algorithms;

public class IncreasingDecreasingString {
    
    public String sortString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        int add = 1, begin = 0, end = 25;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i = begin; i != end + add; i += add)
                if (count[i]-- > 0)
                    sb.append((char) (i + 'a'));
            int temp = begin;
            begin = end;
            end = temp;
            add = -add;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new IncreasingDecreasingString().sortString("aaaabbbbcccc"));
    }

}
