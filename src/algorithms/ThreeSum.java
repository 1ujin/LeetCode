package algorithms;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    
	// method 1 超出时间限制
    public static List<List<Integer>> threeSum1(int[] nums) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	int l = 0;
    	if (nums.length < 3) return list;
    	for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						list.add(new ArrayList<Integer>());
						list.get(l).add(nums[i]);
						if (nums[j] > nums[i]) {
							list.get(l).add(nums[j]);
						} else {							
							list.get(l).add(0, nums[j]);
						}
						if (nums[k] > list.get(l).get(1)) {
							list.get(l).add(nums[k]);
						} else if (nums[k] < list.get(l).get(0)) {
							list.get(l).add(0, nums[k]);
						} else {
							list.get(l).add(1, nums[k]);
						}
						for (int m = 0; m < list.size() - 1; m++) {
							if (list.get(m).equals(list.get(l))) {
								list.remove(list.size() - 1);
								l--;
								break;
							}
						}
						l++;
					}
					
				}
				
			}
			
		}
        return list;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.print(threeSum1(new int[] {-1, 0, 1, 2, -1, -4}));
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
