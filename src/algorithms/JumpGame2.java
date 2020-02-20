package algorithms;

public class JumpGame2 {
    
    // method 1 greedy algorithm
    public static int jump1(int[] nums) {
        int current = 0, max = 0, step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 更新下一步最远到达的距离
            max = max > i + nums[i] ? max : i + nums[i];
            // 如果直接到达最后则立刻跳出循环
            if (max == nums.length - 1) {
                step++;
                break;
            }
            // 到 i 位置为止若没有更远的距离则执行这一步并计入总步数
            if (i == current) {
                current = max;
                step++;
            }
        }
        return step;
    }
    
    // method 2 greedy algorithm slow
    public static int jump2(int[] nums) {
        int position = nums.length - 1, step = 0;
        while (position > 0) {
            // 从最远处开始找
            for (int i = 0; i < position; i++) {
                // 满足下一步能到达甚至超过当前位置的位置
                if (i + nums[i] >= position) {
                    step++;
                    position = i;
                    break;
                }
            }
        }
        return step;
    }
    
    // method 3 dynamic programming time limit exceeded
    public static int jump3(int[] nums) {
        int len = nums.length, step = 0;
        boolean[] tmp = new boolean[len];
        boolean[] dp = new boolean[len];
        tmp[0] = true;
        for (int i = 1; i < len; i++) {
            step++;
            for (int k = i; k < len; k++) {
                if (tmp[k - 1]) {
                    for (int j = k; j <= k + nums[k - 1] - 1; j++) {
                        if (j >= len - 1) {
                            return step;
                        } else {
                            dp[j] = true;
                        }
                    }
                }
            }
            tmp = dp;
            dp = new boolean[len];
        }
        return step;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int result = jump3(new int[] {2, 3, 1, 1, 4});
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
