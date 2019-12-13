package algorithms;

public class PalindromeNumber {
    
    // method 1 字符串对称法
    public static boolean isPalindrome1(int x) {
        String s = String.valueOf(x);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) return false;
        }
        return true;
    }
    
    // method 2 构造一半位数的逆序数
    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        isPalindrome2(123454321);
        long endTime = System.nanoTime();
        System.out.println("Duration: " + (endTime - startTime) + "ns");
    }

}
