package multiThreading.exer;

/**
 * Created by shengchao wu on 4/8/2018.
 */
public class App {
    public static void main(String[] args) {

        Account account = new Account(0);
        User user1 = new User(account);
        User user2 = new User(account);

        Thread t1 = new Thread(user1);
        Thread t2 = new Thread(user2);

        t1.start();
        t2.start();
    }
}
