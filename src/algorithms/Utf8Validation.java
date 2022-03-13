package algorithms;

public class Utf8Validation {

    public boolean validUtf8(int[] data) {
        if (data.length == 5 && data[0] == 250 || data[0] == 254)
            return false;
        int sum = 0;
        for (int octet : data) {
            if (sum > 0) {
                // 只有10xxxxxx的情况
                if (octet >>> 6 == 0b10)
                    sum--;
                else
                    return false;
            } else if (octet >>> 7 == 0b1) {
                int tmp = octet;
                // 根据开头1的数量计算第一个编码共有几个字节
                while ((tmp & 0b10000000) == 0b10000000) {
                    sum++;
                    tmp <<= 1;
                }
                // 第一个字节不会出现开头只有1个1
                if (sum == 1)
                    return false;
                sum--;
            }
        }
        return sum <= 0;
    }

    public static void main(String[] args) {
        int[] data = { 197, 130, 1 };
        System.out.println(new Utf8Validation().validUtf8(data));
    }

}
