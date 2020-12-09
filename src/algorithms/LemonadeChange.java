package algorithms;

public class LemonadeChange {
    
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[4];
        for (int bill : bills) {
            change[bill / 5 - 1]++;
            if (bill != 5) {
                bill -= 5;
                for (int i = 2; i >= 0 && bill > 0;) {
                    if (bill > i * 5 && change[i] > 0) {
                        bill -= (i + 1) * 5;
                        change[i]--;
                    } else i--;
                }
                if (bill > 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = { 5, 5, 5, 10, 20 };
        System.out.println(new LemonadeChange().lemonadeChange(bills));
    }

}
