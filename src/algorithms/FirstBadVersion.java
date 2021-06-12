package algorithms;

class VersionControl {
    
    int firstBad;
    
    boolean isBadVersion(int n) {
        return n >= firstBad;
    }
    
}

public class FirstBadVersion extends VersionControl {
    
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (isBadVersion(mid))
                hi = mid;
            else lo = mid + 1;
        }
        return hi;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        firstBadVersion.firstBad = 1702766719;
        System.out.println(firstBadVersion.firstBadVersion(2126753390));
    }

}
