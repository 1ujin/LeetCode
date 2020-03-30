package lcci;

public class PatternMatching {
    
    public boolean patternMatching(String pattern, String value) {
        if (pattern.length() == 0 && value.length() == 0) return true;
        if (pattern.length() == 0) return false;
        int countA = 0, countB = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'a') countA++;
            else countB++;
        }
        int len = value.length(), lenA = 0;
        if (countA == 0 && len % countB != 0) return false;
        if (countB == 0 && len % countA != 0) return false;
        while (lenA <= len && lenA * countA <= len) {
            if (countB == 0 || (len - countA * lenA) % countB == 0) {
                int lenB = countB == 0 ? 0 : (len - countA * lenA) / countB;
                int startA = pattern.indexOf('a');
                int startB = pattern.indexOf('b');
                if (startA == 0 && startB != -1) startB = startB * lenA;
                else if (startB == 0 && startA != -1) startA = startA * lenB;
                String a = startA == -1 ?
                        "" : value.substring(startA, startA + lenA);
                String b = startB == -1 ?
                        "" : value.substring(startB, startB + lenB);
                if (a.equals(b) && countA != 0 && countB != 0) {
                    lenA++;
                    continue;
                }
                int index = 0;
                for (int i = 0; i < pattern.length(); i++) {
                    if (pattern.charAt(i) == 'a') {
                        if (!a.equals(value.substring(index, index + lenA)))
                            break;
                        else
                            index += lenA;
                    } else {
                        if (!b.equals(value.substring(index, index + lenB)))
                            break;
                        else
                            index += lenB;
                    }
                }
                if (index == len) return true;
            }
            lenA++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PatternMatching().
                patternMatching("aabab", "catcatgocatgo"));
    }

}
