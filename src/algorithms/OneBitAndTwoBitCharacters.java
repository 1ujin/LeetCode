package algorithms;

public class OneBitAndTwoBitCharacters {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1)
            i += bits[i] + 1;
        return i == bits.length - 1;
    }

    public static void main(String[] args) {
        int[] bits = { 1, 1, 1, 0 };
        System.out.println(new OneBitAndTwoBitCharacters().isOneBitCharacter(bits));
    }

}
