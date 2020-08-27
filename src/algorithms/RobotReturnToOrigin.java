package algorithms;

public class RobotReturnToOrigin {
    
    public boolean judgeCircle(String moves) {
        char[] cs = moves.toCharArray();
        int v = 0, h = 0;
        for (char c : cs)
            switch (c) {
                case 'U':
                    v++;
                    break;
                case 'D':
                    v--;
                    break;
                case 'L':
                    h++;
                    break;
                case 'R':
                    h--;
                    break;
                default:
                    break;
            }
        return v == 0 && h == 0;
    }

    public static void main(String[] args) {
        System.out.println(new RobotReturnToOrigin().judgeCircle("UD"));
    }

}
