package algorithms;

public class MinimumInitialEnergyToFinishTasks {
    
    public int minimumEffort(int[][] tasks) {
        int ans = 0, min = 0x7fffffff, max = 0;
        for(int[] task : tasks) {
            ans += task[0];
            max = Math.max(max, task[1]);
            min = Math.min(min, task[1] - task[0]);
        }
        return Math.max(max, ans + min);
    }

    public static void main(String[] args) {
        int[][] tasks = { { 1, 3 }, { 2, 4 }, { 10, 11 }, { 10, 12 }, { 8, 9 } };
        System.out.println(new MinimumInitialEnergyToFinishTasks().minimumEffort(tasks));
    }

}
