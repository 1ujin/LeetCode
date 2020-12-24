package algorithms;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j])
                i++;
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] g = { 1, 2 }, s = { 1, 2, 3 };
        System.out.println(new AssignCookies().findContentChildren(g, s));
    }

}
