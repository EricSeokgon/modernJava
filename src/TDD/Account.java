package TDD;

public class Account {
    private int balnace;

    public Account(int money) {
        this.balnace = money;
    }

    public int getBalance() {
        return this.balnace;
    }

    public void deposit(int i) {
        this.balnace += i;
    }

    public void withdraw(int i) {
        this.balnace -= i;
    }
}
