package algorithms;

public class NumberOfStepsToReduceANumberToZero {

    public int numberOfSteps(int num) {
        if (num == 0)
            return 0;
        return numberOfSteps(num % 2 == 0 ? num >> 1 : num - 1) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfStepsToReduceANumberToZero().numberOfSteps(14));
    }

}
