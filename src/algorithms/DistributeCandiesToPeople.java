package algorithms;

public class DistributeCandiesToPeople {
    
    // method 1
    public int[] distributeCandies1(int candies, int num_people) {
        int n = 0, p = 0;
        int[] people = new int[num_people];
        while (candies >= ++n) {
            people[p++] += n;
            candies -= n;
            if (p >= num_people) p = 0;
        }
        people[p] += candies;
        return people;
    }
    
    // method 2 fastest
    public int[] distributeCandies2(int candies, int num_people) {
        int n = num_people;
        // how many people received complete gifts
        int p = (int) (Math.sqrt(2 * candies + 0.25) - 0.5);
        int remaining = (int) (candies - (p + 1) * p * 0.5);
        int rows = p / n, cols = p % n;

        int[] d = new int[n];
        for(int i = 0; i < n; ++i) {
        // complete rows
        d[i] = (i + 1) * rows + (int) (rows * (rows - 1) * 0.5) * n;
        // cols in the last row
        if (i < cols) d[i] += i + 1 + rows * n;
        }
        // remaining candies        
        d[cols] += remaining;
        return d;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] result = new DistributeCandiesToPeople().distributeCandies2(29, 3);
        long endTime = System.nanoTime();
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + ",");
        System.out.print("\nDuration: " + (endTime - startTime) + "ns");
    }

}
