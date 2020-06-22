package algorithms;

public class AddBinary {
    
    public String addBinary(String a, String b) {
        char[] as = a.toCharArray(), bs = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = as.length - 1, j = bs.length - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += i >= 0 ? as[i] - '0' : 0;
            sum += j >= 0 ? bs[j] - '0' : 0;
            sb.append(sum & 1);
            carry = sum >> 1;
        }
        if (carry == 1)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1010", "1011"));
    }

}
