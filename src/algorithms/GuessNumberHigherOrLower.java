package algorithms;

class GuessGame {
    
    int pick;
    
    /** 
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return       -1 if num is lower than the guess number
     *                1 if num is higher than the guess number
     *               otherwise return 0
     */
    int guess(int num) {
        return pick < num ? -1 : pick > num ? 1 : 0;
    }
    
}

public class GuessNumberHigherOrLower extends GuessGame {
    
    public int guessNumber(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1), g = guess(mid);
            if (g == -1)
                hi = mid - 1;
            else if (g == 1)
                lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower game = new GuessNumberHigherOrLower();
        game.pick = 6;
        System.out.println(game.guessNumber(10));
    }

}
