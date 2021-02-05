package algorithms;

public class GetEqualSubstringsWithinBudget {
    
    public int equalSubstring(String s, String t, int maxCost) {
        char[] ss = s.toCharArray(), ts = t.toCharArray();
        int[] costs = new int[ss.length];
        for (int i = 0; i < costs.length; i++)
            costs[i] = Math.abs(ss[i] - ts[i]);
        int left = 0, right = 0, sum = 0, max = 0;
        while (right < costs.length) {
            if (maxCost >= sum + costs[right])
                sum += costs[right++];
            else sum -= costs[left++];
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring("abcd", "bcdf", 3));
    }

}
