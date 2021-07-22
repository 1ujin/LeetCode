package algorithms;

public class CheckIfAllTheIntegersInARangeAreCovered {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[52];
        for (int[] range : ranges) {
            diff[range[0]]++;
            diff[range[1] + 1]--;
        }
        for (int i = 1, curr = 0; i < 52; i++)
            if ((curr += diff[i]) == 0 && i >= left && i <= right)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] ranges = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        System.out.println(new CheckIfAllTheIntegersInARangeAreCovered().isCovered(ranges, 2, 5));
    }

}
