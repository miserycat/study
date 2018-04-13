package multiThreading.exer;

/**
 * Created by shengchao wu on 4/9/2018.
 */
public class CustomerTwo implements Runnable{
    private Account account;

    public CustomerTwo(Account account) {
        this.account = account;
    }

    public CustomerTwo() {
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
            account.withdraw(1000);
        }
    }
}
