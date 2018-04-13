package multiThreading.exer;

/**
 * Created by shengchao wu on 4/9/2018.
 */
public class App2 {
    public static void main(String[] args) {
        Account account = new Account();

        CustomerOne c1 = new CustomerOne(account);
        CustomerTwo c2 = new CustomerTwo(account);

        new Thread(c1).start();
        new Thread(c2).start();


    }
}
