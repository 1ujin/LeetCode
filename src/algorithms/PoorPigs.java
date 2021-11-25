package algorithms;

public class PoorPigs {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int round = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(round));
    }

    public static void main(String[] args) {
        System.out.println(new PoorPigs().poorPigs(1000, 15, 60));
    }

}
