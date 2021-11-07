package algorithms;

public class BullsAndCows {

    public String getHint(String secret, String guess) {
        char[] cs1 = secret.toCharArray(), cs2 = guess.toCharArray();
        int[] count1 = new int[10], count2 = new int[10];
        int a = 0, b = 0;
        for (int i = 0; i < cs1.length; i++) {
            if (cs1[i] == cs2[i])
                a++;
            count1[cs1[i] - '0']++;
            count2[cs2[i] - '0']++;
        }
        for (int i = 0; i < 10; i++)
            b += Math.min(count1[i], count2[i]);
        StringBuilder sb = new StringBuilder();
        sb.append(a).append('A').append(b - a).append('B');
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BullsAndCows().getHint("1807", "7810"));
    }

}
