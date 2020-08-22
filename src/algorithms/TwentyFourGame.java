package algorithms;

import java.util.ArrayList;
import java.util.List;

public class TwentyFourGame {
    
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3, TARGET = 24;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<Double>();
        for (int num : nums)
            list.add((double) num);
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        if (list.size() == 0) return false;
        if (list.size() == 1)
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<Double>();
                    for (int k = 0; k < size; k++)
                        if (k != i && k != j)
                            list2.add(list.get(k));
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) continue;
                        switch (k) {
                            case ADD:
                                list2.add(list.get(i) + list.get(j));
                                break;
                            case MULTIPLY:
                                list2.add(list.get(i) * list.get(j));
                                break;
                            case SUBTRACT:
                                list2.add(list.get(i) - list.get(j));
                                break;
                            case DIVIDE:
                                if (Math.abs(list.get(j)) < EPSILON) continue;
                                else list2.add(list.get(i) / list.get(j));
                            default:
                                break;
                        }
                        if (solve(list2)) return true;
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 8, 7 };
        System.out.println(new TwentyFourGame().judgePoint24(nums));
    }

}
