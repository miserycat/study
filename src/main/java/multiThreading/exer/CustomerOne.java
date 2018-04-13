package multiThreading.exer;

/**
 * Created by shengchao wu on 4/9/2018.
 */
public class CustomerOne implements Runnable{
    private Account account;

    public CustomerOne(Account account) {
        this.account = account;
    }

    public CustomerOne() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            account.deposit(1000);
        }
    }
}
