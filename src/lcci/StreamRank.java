package lcci;

public class StreamRank {

    private class StreamRankNode {

        public int val;
        public int count;
        public StreamRankNode left;
        public StreamRankNode right;

        public StreamRankNode(int x, int y) {
            val = x;
            count = y;
        }

    }

    private StreamRankNode root;

    public StreamRank() {
        root = null;
    }

    public void track(int x) {
        if (root == null) {
            root = new StreamRankNode(x, 1);
            return;
        }
        StreamRankNode node = root;
        while (node.left != null || node.right != null) {
            if (x == node.val) {
                node.count++;
                return;
            } else if (node.left != null && x < node.val) {
                node.count++;
                node = node.left;
            } else if (node.right != null && x > node.val)
                node = node.right;
            else break;
        }
        if (x <= node.val) node.count++;
        if (x < node.val) {
            node.left = new StreamRankNode(x, 1);
        } else if (x > node.val)
            node.right = new StreamRankNode(x, 1);
    }

    public int getRankOfNumber(int x) {
        StreamRankNode node = root;
        int count = 0;
        while (node != null) {
            if (x == node.val) {
                count += node.count;
                break;
            } else if (x > node.val) {
                count += node.count;
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        StreamRank obj = new StreamRank();
        obj.track(4);
        obj.track(4);
        obj.track(3);
        obj.track(3);
        obj.track(5);
        obj.track(5);
        obj.track(1);
        obj.track(1);
        obj.track(1);
        obj.track(6);
        System.out.println(obj.getRankOfNumber(7));
    }

}
