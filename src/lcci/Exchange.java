package lcci;

public class Exchange {
    
    public int exchangeBits(int num) {
        return (num & 0xaaaaaaaa) >>> 1 | (num & 0x55555555) << 1;
    }

    public static void main(String[] args) {
        System.out.println(new Exchange().exchangeBits(3));
    }

}
