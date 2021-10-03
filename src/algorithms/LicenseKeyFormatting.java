package algorithms;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {
        char[] cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = cs.length - 1, count = 0; i >= 0; i--) {
            if (cs[i] == '-')
                continue;
            sb.append(Character.toUpperCase(cs[i]));
            if (++count == k && i != 0) {
                sb.append("-");
                count = 0;
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-')
            sb.deleteCharAt(sb.length() - 1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }

}
