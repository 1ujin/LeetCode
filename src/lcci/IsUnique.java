package lcci;

public class IsUnique {
    
    // method 1 bitmap
    public boolean isUnique1(String astr) {
        long low = 0, high = 0;
        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long tmp = 1L << c - 64;
                if ((high & tmp) != 0) return false;
                high |= tmp;
            } else {
                long tmp = 1L << c;
                if ((low & tmp) != 0) return false;
                low |= tmp;
            }
        }
        return true;
    }
    
    // method 2 a little bit faster
    public boolean isUnique2(String astr) {
        for (int i = 0; i < astr.length(); i++)
            if (astr.indexOf(astr.charAt(i), i + 1) > -1)
                return false;
        return true;
    }

    public static void main(String[] args) {
        IsUnique solution = new IsUnique();
        long startTime = System.nanoTime();
        boolean result = solution.isUnique2("leetcode");
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
