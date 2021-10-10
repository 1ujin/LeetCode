package algorithms;

public class IntegerToEnglishWords {

    private static final String[] SINGLE = { "", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine" };
    private static final String[] TEEN = { "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };
    private static final String[] TY = { "", "Ten", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    private static final String[] THOUSAND = { "", "Thousand", "Million",
            "Billion" };

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        StringBuilder sb = new StringBuilder();
        for (int i = 3, unit = 1000000000; i >= 0; i--, unit /= 1000) {
            int threeBits = num / unit;
            if (threeBits == 0)
                continue;
            num %= unit;
            if (threeBits >= 100) {
                sb.append(SINGLE[threeBits / 100]);
                sb.append(" Hundred ");
                threeBits %= 100;
            }
            if (threeBits >= 20) {
                sb.append(TY[threeBits / 10]);
                sb.append(" ");
                threeBits %= 10;
            }
            if (threeBits >= 10) {
                sb.append(TEEN[threeBits -= 10]);
                sb.append(" ");
            } else if (threeBits > 0) {
                sb.append(SINGLE[threeBits]);
                sb.append(" ");
            }
            sb.append(THOUSAND[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToEnglishWords().numberToWords(12345));
    }

}
