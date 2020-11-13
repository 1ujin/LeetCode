package algorithms;

public class BulbSwitcher4 {
    
    public int minFlips(String target) {
        char[] cs = target.toCharArray();
        int count = cs[0] == '0' ? 0 : 1;
        for (int i = 1; i < cs.length; i++)
            if (cs[i] != cs[i - 1])
                count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new BulbSwitcher4().minFlips("001011101"));
    }

}
