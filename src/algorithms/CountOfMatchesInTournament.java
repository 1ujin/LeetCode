package algorithms;

public class CountOfMatchesInTournament {
    
    // method 1 recursion
    public int numberOfMatches1(int n) {
        if (n <= 1) return 0;
        return (n >> 1) + numberOfMatches1(n + 1 >> 1);
    }
    
    // method 2
    public int numberOfMatches2(int n) {
        return --n;
    }

    public static void main(String[] args) {
        System.out.println(new CountOfMatchesInTournament().numberOfMatches2(7));
    }

}
