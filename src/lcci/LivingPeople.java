package lcci;

import java.util.Arrays;

public class LivingPeople {
    
    // method 1 counting sort
    public int maxAliveYear1(int[] birth, int[] death) {
        int[] count = new int[101];
        for (int i = 0; i < birth.length; i++)
            for (int j = birth[i]; j <= death[i]; j++)
                count[j - 1900]++;
        int max = 0;
        for (int i = max; i < 101; i++)
            max = count[max] >= count[i] ? max : i;
        return max + 1900;
    }
    
    // method 2
    public int maxAliveYear2(int[] birth, int[] death) {
        Arrays.sort(birth);
        Arrays.sort(death);
        int count = 0, max = 0, byr = 0, dyr = 0, maxyr = 0;
        while (byr < birth.length) {
            while (death[dyr] < birth[byr]) {
                count--;
                dyr++;
            }
            count++;
            if (max < count) {
                max = count;
                maxyr = byr;
            }
            byr++;
        }
        return birth[maxyr];
    }

    public static void main(String[] args) {
        int[] birth = {1900, 1901, 1950};
        int[] death = {1948, 1951, 2000};
        System.out.println(new LivingPeople().maxAliveYear2(birth, death));
    }

}
