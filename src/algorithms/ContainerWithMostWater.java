package algorithms;

public class ContainerWithMostWater {
	
	// method 1
	public static int maxArea1(int[] height) {
		int ret = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int tmp = Math.min(height[i], height[j]) * (j - i);
				if (tmp > ret) ret = tmp;
			}
		}
		return ret;
	}
	
	// method 2
	public static int maxArea2(int[] height) {
		int ret = 0, i = 0, j = height.length - 1;
		while (i < j) {
			int tmp = Math.min(height[i], height[j]) * (j - i);
			if (tmp > ret) ret = tmp;
			if (height[i] < height[j]) i++;
			else j--;
		}
		return ret;
	}

    public static void main(String[] args) {
    	long startTime = System.nanoTime();
        maxArea2(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7});
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
