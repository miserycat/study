package multiThreading.exer;

/**
 * Created by shengchao wu on 4/8/2018.
 */
public class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public synchronized void deposit(double money) {
        if (balance >= 10000) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
            System.out.println("balance must less than 10000");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            balance+= money;
            System.out.println("deposit 1000, current balance is:" + balance);
        }
    }

    public synchronized void withdraw (double money) {
        if (balance <= 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notify();
            System.out.println("balance not enough");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            balance -= money;
            System.out.println("withdraw 1000, current balance is:" + balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
