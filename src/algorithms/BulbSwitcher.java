package algorithms;

public class BulbSwitcher {

    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }

    public static void main(String[] args) {
        System.out.println(new BulbSwitcher().bulbSwitch(3));
    }

}
