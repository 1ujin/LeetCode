package algorithms;

public class FriendsOfAppropriateAges {

    public int numFriendRequests(int[] ages) {
        int[] count = new int[121], prefix = new int[121];
        for (int age : ages)
            count[age]++;
        for (int i = 1; i < 121; i++)
            prefix[i] = prefix[i - 1] + count[i];
        int req = 0;
        for (int i = 15; i < 121; i++)
            if (count[i] > 0)
                req += count[i] * (prefix[i] - prefix[(i >> 1) + 7] - 1);
        return req;
    }

    public static void main(String[] args) {
        int[] ages = { 20, 30, 100, 110, 120 };
        System.out.println(new FriendsOfAppropriateAges().numFriendRequests(ages));
    }

}
