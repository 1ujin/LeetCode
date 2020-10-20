package algorithms;

public class LongPressedName {
    
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        char[] cs1 = name.toCharArray(), cs2 = typed.toCharArray();
        while (i < cs1.length) {
            if (j >= cs2.length) return false;
            if (cs1[i] == cs2[j]) {
                i++;
                j++;
            } else if (j > 0 && cs2[j] == cs2[j - 1]) {
                j++;
            } else return false;
        }
        while (j < cs2.length) {
            if (j > 0 && cs2[j] == cs2[j - 1])
                j++;
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LongPressedName().isLongPressedName("pyplrz", "ppyypllr"));
    }

}
