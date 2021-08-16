package algorithms;

public class StudentAttendanceRecord1 {
    
    public boolean checkRecord(String s) {
        char[] cs = s.toCharArray();
        int a = 0, l = 0;
        for (char c : cs) {
            if (c == 'A')
                if (++a > 1)
                    return false;
            if (c == 'L') {
                if (++l > 2)
                    return false;
            } else l = 0;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new StudentAttendanceRecord1().checkRecord("PPALLP"));
    }

}
