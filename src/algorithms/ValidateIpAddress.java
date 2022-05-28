package algorithms;

public class ValidateIpAddress {

    public String validIPAddress(String queryIP) {
        if (queryIP.indexOf('.') > -1) {
            String[] nums = queryIP.split("\\.", -1);
            if (nums.length != 4)
                return "Neither";
            for (String num : nums)
                if (valueOf(num) < 0)
                    return "Neither";
            return "IPv4";
        } else if (queryIP.indexOf(':') > -1) {
            String[] nums = queryIP.split(":", -1);
            if (nums.length != 8)
                return "Neither";
            for (String num : nums)
                if (valueOfHex(num) < 0)
                    return "Neither";
            return "IPv6";
        }
        return "Neither";
    }

    private int valueOf(String s) {
        int value = 0;
        char[] cs = s.toCharArray();
        if (cs.length < 1 || cs.length > 1 && cs[0] == '0')
            return -1;
        for (char c : cs) {
            if (c < '0' || c > '9')
                return -1;
            value = value * 10 + c - '0';
            if (value > 255)
                return -1;
        }
        return value;
    }

    private int valueOfHex(String hex) {
        if (hex.length() < 1 || hex.length() > 4)
            return -1;
        int value = 0;
        for (char c : hex.toCharArray()) {
            if (c >= '0' && c <= '9')
                value = value * 16 + c - '0';
            else if (c >= 'A' && c <= 'F')
                value = value * 16 + c - 'A' + 10;
            else if (c >= 'a' && c <= 'f')
                value = value * 16 + c - 'a' + 10;
            else
                return -1;
            if (value > 0xffff)
                return -1;
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(new ValidateIpAddress()
                .validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }

}
