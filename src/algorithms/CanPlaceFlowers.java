package algorithms;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int left = -2, right = -1, i = 0;
        for (; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                right = i;
                if (right - left > 3)
                    n -= (right - left - 2) >> 1;
                left = right;
                if (n <= 0) return true;
            }
        }
        if (right < 0)
            return i + 1 >> 1 >= n;
        return right < i - 2 && (i - right - 1) >> 1 >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = { 1, 0, 0, 0, 1, 0, 0 };
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 2));
    }

}
