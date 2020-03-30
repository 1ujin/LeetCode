package lcci;

import java.util.Arrays;

public class MasterMind {
    
    public int[] masterMind(String solution, String guess) {
        int real = 0, fake = 0;
        char[] s = solution.toCharArray(), g = guess.toCharArray();
        for (int i = 0; i < 4; i++)
            if (s[i] == g[i])
                real++;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (s[i] == g[j]) {
                    s[i] = '.';
                    g[j] = ' ';
                    fake++;
                }
        return new int[] {real, fake - real};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MasterMind().
                masterMind("RGBY", "GGRR")));
    }

}
