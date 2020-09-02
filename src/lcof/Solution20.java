package lcof;

public class Solution20 {
    
    public boolean isNumber(String s) {
        int state = 0, finals = 0b101101000;
        int[][] matrix = { 
                {  0,  1,  6,  2, -1 },
                { -1, -1,  6,  2, -1 },
                { -1, -1,  3, -1, -1 },
                {  8, -1,  3, -1,  4 },
                { -1,  7,  5, -1, -1 },
                {  8, -1,  5, -1, -1 },
                {  8, -1,  6,  3,  4 },
                { -1, -1,  5, -1, -1 },
                {  8, -1, -1, -1, -1 } };
        for (char c : s.toCharArray()) {
            int id = -1;
            switch (c) {
                case ' ': id = 0; break;
                case '+':
                case '-': id = 1; break;
                case '.': id = 3; break;
                case 'E':
                case 'e': id = 4; break;
                default: if (c >= '0' && c <= '9') id = 2;
            }
            if (id < 0) return false;
            state = matrix[state][id];
            if (state < 0) return false;
        }
        return (finals & 1 << state) > 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution20().isNumber("+100"));
    }

}
