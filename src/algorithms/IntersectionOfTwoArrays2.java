package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays2 {

    // method 1
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return intersect1(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1)
            map.compute(i, (k, v) -> v == null ? 1 : ++v);
        int[] arr = new int[nums1.length];
        int index = 0;
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                arr[index++] = i;
                map.merge(i, -1, (oldVal, newVal) -> oldVal + newVal);
            }
        }
        return Arrays.copyOfRange(arr, 0, index);
    }
    
    // method 2 fastest
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] arr = new int[len1 < len2 ? len1 : len2];
        int idx = 0, idx1 = 0, idx2 = 0;
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1] < nums2[idx2])
                idx1++;
            else if (nums1[idx1] > nums2[idx2])
                idx2++;
            else {
                arr[idx++] = nums1[idx1++];
                idx2++;
            }
        }
        return Arrays.copyOfRange(arr, 0, idx);
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 9, 5 }, nums2 = { 9, 4, 9, 8, 4 };
        System.out.println(Arrays.toString(
                new IntersectionOfTwoArrays2().intersect2(nums1, nums2)));
    }

}
