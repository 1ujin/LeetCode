package algorithms;

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    
    public int minPartitions(String n) {
        int min = 0;
        for (char c : n.toCharArray())
            min = Math.max(c - '0', min);
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new PartitioningIntoMinimumNumberOfDeciBinaryNumbers().minPartitions("32"));
    }

}
