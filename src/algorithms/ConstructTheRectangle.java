package algorithms;

import java.util.Arrays;

public class ConstructTheRectangle {

    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        for (; area % w != 0; w--);
        return new int[] { area / w, w };
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ConstructTheRectangle().constructRectangle(4)));
    }

}
