package algorithms;

public class MaximumXorOfTwoNumbersInAnArray {

    private class Trie {
        Trie zero, one;
    }

    public int findMaximumXOR(int[] nums) {
        int xor = 0;
        Trie root = new Trie();
        for (int i = 1; i < nums.length; i++) {
            makeTrie(root, nums[i - 1]);
            xor = Math.max(xor, makeInt(root, nums[i]));
        }
        return xor;
    }

    private void makeTrie(Trie root, int num) {
        Trie trie = root;
        for (int k = 30; k >= 0; k--) {
            if (((num >> k) & 1) == 0) {
                if (trie.zero == null)
                    trie.zero = new Trie();
                trie = trie.zero;
            } else {
                if (trie.one == null)
                    trie.one = new Trie();
                trie = trie.one;
            }
        }
    }

    public int makeInt(Trie root, int num) {
        int x = 0;
        Trie trie = root;
        for (int k = 30; k >= 0; k--) {
            x <<= 1;
            if (((num >> k) & 1) == 0) {
                x += trie.one != null ? 1 : 0;
                trie = trie.one != null ? trie.one : trie.zero;
            } else {
                x += trie.zero != null ? 1 : 0;
                trie = trie.zero != null ? trie.zero : trie.one;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
        System.out.println(new MaximumXorOfTwoNumbersInAnArray().findMaximumXOR(nums));
    }

}
