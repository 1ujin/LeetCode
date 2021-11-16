package algorithms;

public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        int len = words.length;
        int[] bmps = new int[len];
        for (int i = 0; i < len; i++) {
            int bmp = 0;
            for (char c : words[i].toCharArray())
                bmp |= 1 << c - 'a';
            bmps[i] = bmp;
        }
        int product = 0;
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                if ((bmps[i] & bmps[j]) == 0)
                    product = Math.max(product,
                            words[i].length() * words[j].length());
        return product;
    }

    public static void main(String[] args) {
        String[] words = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
        System.out.println(new MaximumProductOfWordLengths().maxProduct(words));
    }

}
