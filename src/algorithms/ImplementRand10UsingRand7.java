package algorithms;

class SolBase {
    int rand7() {
        return (int) (Math.random() * 6) + 1;
    }
}

public class ImplementRand10UsingRand7 extends SolBase {

    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7();
            if (num <= 40)
                return 1 + num % 10;
            num = (num - 40 - 1) * 7 + rand7();
            if (num <= 60)
                return 1 + num % 10;
            num = (num - 60 - 1) * 7 + rand7();
            if (num <= 20)
                return 1 + num % 10;
        }
    }

    public static void main(String[] args) {
        ImplementRand10UsingRand7 rand = new ImplementRand10UsingRand7();
        for (int i = 0; i < 5; i++)
            System.out.println(rand.rand10());
    }

}
