package lcci;

public class FactorialZeros {
    
    public int trailingZeroes(int n) {
        int count5 = 0;
        for (; n > 0; n /= 5)
            // 1~5乘积共1个0，6~25乘积共5个0，26~125乘积共25个0……以此类推
            count5 += n / 5;
        return count5;
    }

    public static void main(String[] args) {
        System.out.println(new FactorialZeros().trailingZeroes(26));
    }

}
