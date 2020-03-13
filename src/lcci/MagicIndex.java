package lcci;

public class MagicIndex {
    
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == i) return i;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MagicIndex().findMagicIndex(new int[] {0, 0, 2}));
    }

}
