package algorithms;

public class ReconstructOriginalDigitsFromEnglish {

    public String originalDigits(String s) {
        int[] count = new int[26], arr = new int[10];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        arr[0] = count['z' - 'a'];
        arr[2] = count['w' - 'a'];
        arr[4] = count['u' - 'a'];
        arr[6] = count['x' - 'a'];
        arr[8] = count['g' - 'a'];
        arr[3] = count['h' - 'a'] - arr[8];
        arr[5] = count['f' - 'a'] - arr[4];
        arr[7] = count['s' - 'a'] - arr[6];
        arr[1] = count['o' - 'a'] - arr[0] - arr[2] - arr[4];
        arr[9] = count['i' - 'a'] - arr[5] - arr[6] - arr[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < arr[i]; j++)
                sb.append(i);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReconstructOriginalDigitsFromEnglish()
                .originalDigits("owoztneoer"));
    }

}
