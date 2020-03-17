package algorithms;

public class RectangleOverlap {
    
    // method 1
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        if (rec1[0] >= rec2[2] || rec1[1] >= rec2[3] || rec1[2] <= rec2[0] || rec1[3] <= rec2[1]) return false;
        return true;
    }
    
    // method 2
    public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        // 最小的顶边大于最大的底边且最小的右边大于最大的左边
        return (Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1])) && (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]));
    }

    public static void main(String[] args) {
        System.out.println(new RectangleOverlap().isRectangleOverlap2(new int[] {0, 0, 2, 2}, new int[] {1, 1, 3, 3}));
    }

}
