package algorithms;

public class CountTripletsThatCanFormTwoArraysOfEqualXor {

    public int countTriplets(int[] arr) {
        int count = 0, len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = i, xorsum = 0; j < len; j++) {
                xorsum ^= arr[j];
                if (xorsum == 0)
                    count += j - i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 11, 12, 9, 5, 2, 7, 17, 22 };
        System.out.println(new CountTripletsThatCanFormTwoArraysOfEqualXor().countTriplets(arr));
    }

}
