package algorithms;

public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int num = left; num <= right; num++)
            if (isPrime(Integer.bitCount(num)))
                count++;
        return count;
    }

    private boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++)
            if (num % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PrimeNumberOfSetBitsInBinaryRepresentation()
                .countPrimeSetBits(0, 665772));
    }

}
