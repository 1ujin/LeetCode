package lcci;

public class CompressString {
    
    public String compressString(String S) {
        int len = S.length(), count = 1;
        if (len < 3) return S;
        StringBuilder sb = new StringBuilder();
        sb.append(S.charAt(0));
        for (int i = 1; i < len; i++) {
            if (S.charAt(i) == sb.charAt(sb.length() - 1))
                count++;
            else {
                sb.append(count);
                sb.append(S.charAt(i));
                count = 1;
            }
        }
        sb.append(count);
        return sb.length() < len ? sb.toString() : S;
    }

    public static void main(String[] args) {
        CompressString solution = new CompressString();
        long startTime = System.nanoTime();
        String result = solution.compressString("aabcccccaaa");
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
