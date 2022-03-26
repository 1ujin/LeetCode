package algorithms;

public class BaseballGame {

    public int calPoints(String[] ops) {
        int len = ops.length, i = 0, sum = 0;
        int[] points = new int[len];
        for (String op : ops) {
            switch (op) {
                case "+":
                    points[i] = points[i - 1] + points[i - 2];
                    break;
                case "D":
                    points[i] = points[i - 1] * 2;
                    break;
                case "C":
                    points[--i] = 0;
                    i--;
                    break;
                default:
                    points[i] = Integer.parseInt(op);
                    break;
            }
            i++;
        }
        for (int point : points)
            sum += point;
        return sum;
    }

    public static void main(String[] args) {
        String[] ops = { "5", "2", "C", "D", "+" };
        System.out.println(new BaseballGame().calPoints(ops));
    }

}
