package algorithms;

public class ConsecutiveCharacters {

    public int maxPower(String s) {
        char[] cs = s.toCharArray();
        int power = 1, tmp = 1;
        for (int i = 1; i < cs.length; i++, tmp++) {
            if (cs[i] != cs[i - 1]) {
                power = Math.max(power, tmp);
                tmp = 0;
            }
        }
        return Math.max(power, tmp);
    }

    public static void main(String[] args) {
        System.out.println(new ConsecutiveCharacters().maxPower("abbcccddddeeeeedcba"));
    }

}
