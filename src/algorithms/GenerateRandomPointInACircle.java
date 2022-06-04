package algorithms;

import java.util.Arrays;
import java.util.Random;

public class GenerateRandomPointInACircle {

    private Random random;
    private double R, x, y;

    public GenerateRandomPointInACircle(
            double radius,
            double x_center,
            double y_center) {
        random = new Random();
        R = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double theta = Math.PI * 2d * random.nextDouble();
        double r = R * Math.sqrt(random.nextDouble());
        double[] postion = { x + r * Math.cos(theta), y + r * Math.sin(theta) };
        return postion;
    }

    public static void main(String[] args) {
        GenerateRandomPointInACircle solution = new GenerateRandomPointInACircle(1.0, 0.0, 0.0);
        System.out.println(Arrays.toString(solution.randPoint())); // 返回[-0.02493，-0.38077]
        System.out.println(Arrays.toString(solution.randPoint())); // 返回[0.82314,0.38945]
        System.out.println(Arrays.toString(solution.randPoint())); // 返回[0.36572,0.17248]
    }

}
