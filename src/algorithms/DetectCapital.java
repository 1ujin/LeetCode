package algorithms;

public class DetectCapital {

    // method 1
    public boolean detectCapitalUse1(String word) {
        char[] cs = word.toCharArray();
        if (cs[0] >= 'a' || cs.length > 1 && cs[1] >= 'a') {
            for (int i = 1; i < cs.length; i++)
                if (cs[i] < 'a')
                    return false;
            return true;
        } else {
            for (int i = 1; i < cs.length; i++)
                if (cs[i] >= 'a')
                    return false;
            return true;
        }
    }

    // method 2
    public boolean detectCapitalUse2(String word) {
        char[] cs = word.toCharArray();
        int index = -1, count = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] < 'a') {
                index = i;
                count++;
            }
        }
        return index < 1 || index == count - 1 && count == cs.length;
    }

    public static void main(String[] args) {
        System.out.println(new DetectCapital().detectCapitalUse2("FFFFFFFFFf"));
    }

}
