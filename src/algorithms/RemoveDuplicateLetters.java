package algorithms;

public class RemoveDuplicateLetters {
    
    public String removeDuplicateLetters(String s) {
        char[] cs = s.toCharArray();
        boolean[] visited = new boolean[26];
        visited[cs[0] - 'a'] = true;
        int[] count = new int[26];
        for (int i = 1; i < cs.length; i++)
            count[cs[i] - 'a']++;
        int len = 1;
        for (int i = 1; i < cs.length; i++) {
            char c = cs[i];
            if (!visited[c - 'a']) {
                for (int j = i - 1; j >= 0; j--) {
                    if (cs[j] == '_')
                        continue;
                    if (cs[j] < c || count[cs[j] - 'a'] == 0)
                        break;
                    visited[cs[j] - 'a'] = false;
                    cs[j] = '_';
                    len--;
                }
                visited[c - 'a'] = true;
                len++;
            } else cs[i] = '_';
            count[c - 'a']--;
        }
        char[] arr = new char[len];
        int i = 0;
        for (char c : cs)
            if (c != '_')
                arr[i++] = c;
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("ecbacba"));
    }

}
