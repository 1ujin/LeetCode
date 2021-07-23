package algorithms;

public class LatestTimeByReplacingHiddenDigits {

    public String maximumTime(String time) {
        char[] cs = time.toCharArray();
        if (cs[0] == '?')
            cs[0] = cs[1] >= '4' && cs[1] <= '9' ? '1' : '2';
        if (cs[1] == '?')
            cs[1] = cs[0] == '2' ? '3' : '9';
        if (cs[3] == '?')
            cs[3] = '5';
        if (cs[4] == '?')
            cs[4] = '9';
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        System.out.println(new LatestTimeByReplacingHiddenDigits().maximumTime("??:??"));
    }

}
