package algorithms;

public class CalculateMoneyInLeetcodeBank {

    public int totalMoney(int n) {
        int week = n / 7, day = n % 7;
        return 7 * (week - 1) * week / 2 + 28 * week + week * day + (1 + day) * day / 2;
    }

    public static void main(String[] args) {
        System.out.println(new CalculateMoneyInLeetcodeBank().totalMoney(20));
    }

}
