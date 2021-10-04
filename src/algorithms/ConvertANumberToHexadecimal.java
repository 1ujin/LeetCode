package algorithms;

public class ConvertANumberToHexadecimal {

    public String toHex(int num) {
        if (num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; i--) {
            int bit = (num >> 4 * i) & 15;
            if (bit <= 0 && sb.length() <= 0)
                continue;
            char c = bit < 10 ? (char) ('0' + bit) : (char) ('a' + bit - 10);
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ConvertANumberToHexadecimal().toHex(-1));
    }

}
