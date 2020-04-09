package lcof;

public class Solution05 {
    
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public static void main(String[] args) {
        System.out.println(new Solution05().replaceSpace("We are happy."));
    }

}
