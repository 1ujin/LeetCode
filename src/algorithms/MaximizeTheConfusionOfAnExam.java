package algorithms;

public class MaximizeTheConfusionOfAnExam {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] cs = answerKey.toCharArray();
        int left = 0, right = 0, max = 0, countT = 0, countF = 0;
        while (right < cs.length) {
            if (cs[right++] == 'T')
                countT++;
            else
                countF++;
            while (countT > k && countF > k) {
                if (cs[left++] == 'T')
                    countT--;
                else
                    countF--;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximizeTheConfusionOfAnExam()
                .maxConsecutiveAnswers("TTFTTFTT", 1));
    }

}
