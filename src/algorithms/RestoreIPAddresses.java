package algorithms;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    
    List<String> list = new ArrayList<>();
    int[] segments = new int[4];
    
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return list;
    }

    private void dfs(String s, int id, int begin) {
        if (id == 4) {
            if (begin == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    sb.append(segments[i]);
                    if (i != 3) sb.append('.');
                }
                list.add(sb.toString());
            }
            return;
        } else if (begin == s.length())
            return;
        else if (s.charAt(begin) == '0') {
            segments[id] = 0;
            dfs(s, id + 1, begin + 1);
        }
        int ip = 0;
        for (int end = begin; end < s.length(); end++) {
            ip = ip * 10 + s.charAt(end) - '0';
            if (ip > 0 && ip < 256) {
                segments[id] = ip;
                dfs(s, id + 1, end + 1);
            } else break;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("25525511135"));
    }

}
