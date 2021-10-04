package algorithms;

public class RectangleArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        int area3 = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1))
                * Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        return area1 + area2 - area3;
    }

    public static void main(String[] args) {
        System.out.println(new RectangleArea().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

}
