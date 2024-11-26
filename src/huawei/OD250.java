package huawei;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * TLV解码
 * <p>
 * length(T) = 1
 * <p>
 * length(L) = 2
 * <p>
 * length(V) = value(L)
 */
public class OD250 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String tag = scanner.nextLine();
            String[] stream = scanner.nextLine().split(" ");
            System.out.println(solution(tag, stream));
        }
    }

    private static String solution(String tag, String[] stream) {
        for (int i = 0; i < stream.length; i++) {
            int len = Integer.valueOf(stream[i + 2] + stream[i + 1], 16);
            if (!stream[i].equals(tag))
                i += len + 2;
            else {
                i += 2;
                StringJoiner sj = new StringJoiner(" ");
                for (int j = 1; j <= len; j++)
                    sj.add(stream[i + j]);
                return sj.toString();
            }
        }
        return null;
    }
}
