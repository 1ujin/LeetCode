package algorithms;

public class SatisfiabilityOfEqualityEquations {
    
    int[] set = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++)
            set[i] = i;
        for (String equation : equations) {
            char[] cs = equation.toCharArray();
            if (cs[1] != '=') continue;
            // 路径压缩
            set[find(cs[0] - 'a')] = find(cs[3] - 'a');
        }
        for (String equation : equations) {
            char[] cs = equation.toCharArray();
            if (cs[1] != '!') continue;
            else if (find(cs[0] - 'a') == find(cs[3] - 'a')) return false;
        }
        return true;
    }

    private int find(int i) {
        while (i != set[i]) {
            set[i] = set[set[i]];
            i = set[i];
        }
        return i;
    }

    public static void main(String[] args) {
        String[] equations = { "a==b", "b!=a" };
        System.out.println(new SatisfiabilityOfEqualityEquations().equationsPossible(equations));
    }

}
