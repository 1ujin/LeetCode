package algorithms;

public class NumberOfSegmentsInAString {

    public int countSegments(String s) {
        char[] cs = s.toCharArray();
        int count = 0;
        for (int i = 0; i < cs.length; i++)
            if ((i == 0 || cs[i - 1] == ' ') && cs[i] != ' ')
                count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSegmentsInAString()
                .countSegments("Hello, my name is John"));
    }

}
