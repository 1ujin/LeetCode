package algorithms;

import java.util.Arrays;

public class MaximumXorWithAnElementFromArray {
    
    private class Trie {
        Trie zero, one;
        int min = Integer.MAX_VALUE;

        public void insert(int num) {
            Trie node = this;
            node.min = Math.min(node.min, num);
            for (int i = 29; i >= 0; i--) {
                if (((num >> i) & 1) == 0) {
                    if (node.zero == null)
                        node.zero = new Trie();
                    node = node.zero;
                } else {
                    if (node.one == null)
                        node.one = new Trie();
                    node = node.one;
                }
                node.min = Math.min(node.min, num);
            }
        }

        public int getMaxXorWithLimit(int num, int limit) {
            Trie node = this;
            if (node.min > limit)
                return -1;
            int max = 0;
            for (int i = 29; i >= 0; i--) {
                if (((num >> i) & 1) == 0) {
                    if (node.one != null && node.one.min <= limit) {
                        max |= 1 << i;
                        node = node.one;
                    } else
                        node = node.zero;
                } else {
                    if (node.zero != null && node.zero.min <= limit) {
                        max |= 1 << i;
                        node = node.zero;
                    } else
                        node = node.one;
                }
            }
            return max;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        for (int num : nums)
            trie.insert(num);
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++)
            answer[i] = trie.getMaxXorWithLimit(queries[i][0], queries[i][1]);
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 2, 4, 6, 6, 3 };
        int[][] queries = { { 12, 4 }, { 8, 1 }, { 6, 3 } };
        System.out.println(Arrays.toString(new MaximumXorWithAnElementFromArray().maximizeXor(nums, queries)));
    }

}
