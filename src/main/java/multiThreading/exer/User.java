package multiThreading.exer;

/**
 * Created by shengchao wu on 4/8/2018.
 */
public class User implements Runnable {

    private Account account;


    public User(Account account) {
        this.account = account;
    }

    public User() {}


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}
