package algorithms;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] ss1 = version1.split("\\."), ss2 = version2.split("\\.");
        int i = 0;
        while (i < ss1.length && i < ss2.length) {
            int s1 = Integer.parseInt(ss1[i]), s2 = Integer.parseInt(ss2[i]);
            i++;
            if (s1 != s2)
                return s1 > s2 ? 1 : -1;
        }
        String[] ss = ss1.length > ss2.length ? ss1 : ss2;
        while (i < ss.length)
            if (Integer.parseInt(ss[i++]) != 0)
                return ss1.length > ss2.length ? 1 : -1;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CompareVersionNumbers().compareVersion("1.01", "1.001"));
    }

}
