package algorithms;

public class SimpleBankSystem {

    private static class Bank {
        private long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1 > balance.length || account2 > balance.length
                    || balance[account1 - 1] < money)
                return false;
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (account > balance.length)
                return false;
            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (account > balance.length || balance[account - 1] < money)
                return false;
            balance[account - 1] -= money;
            return true;
        }
    }

    public static void main(String[] args) {
        long[] balance = { 10, 100, 20, 50, 30 };
        SimpleBankSystem.Bank bank = new SimpleBankSystem.Bank(balance);
        System.out.println(bank.withdraw(3, 10));       // 返回 true ，账户 3 的余额是 $20 ，所以可以取款 $10 。
                                                        // 账户 3 余额为 $20 - $10 = $10 。
        System.out.println(bank.transfer(5, 1, 20));    // 返回 true ，账户 5 的余额是 $30 ，所以可以转账 $20 。
                                                        // 账户 5 的余额为 $30 - $20 = $10 ，账户 1 的余额为 $10 + $20 = $30 。
        System.out.println(bank.deposit(5, 20));        // 返回 true ，可以向账户 5 存款 $20 。
                                                        // 账户 5 的余额为 $10 + $20 = $30 。
        System.out.println(bank.transfer(3, 4, 15));    // 返回 false ，账户 3 的当前余额是 $10 。
                                                        // 所以无法转账 $15 。
        System.out.println(bank.withdraw(10, 50));      // 返回 false ，交易无效，因为账户 10 并不存在。
    }

}
