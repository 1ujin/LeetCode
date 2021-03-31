package algorithms;

public class ClumsyFactorial {
    
    public int clumsy(int N) {
        switch(N) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 6;
            case 4:
                return 7;
            default:
                switch(N % 4) {
                    case 0:
                        return N + 1;
                    case 1:
                    case 2:
                        return N + 2;
                    default:
                        return N - 1;
                }
        }
    }

    public static void main(String[] args) {
        System.out.println(new ClumsyFactorial().clumsy(10));
    }

}
