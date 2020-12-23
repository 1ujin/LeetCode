package algorithms;

public class Candy {

    public int candy(int[] ratings) {
        int pre = 1, sum = 1, inc = 1, dec = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] <= ratings[i]) {
                dec = 0;
                if (ratings[i - 1] == ratings[i])
                    pre = 1;
                else
                    pre++;
                sum += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc)
                    dec++;
                sum += dec;
                pre = 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = { 1, 3, 2, 2, 1 };
        System.out.println(new Candy().candy(ratings));
    }

}
