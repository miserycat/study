package thread02.com.atguigu.exer;

public class Account {

	private double balance;

	public Account() {
	}

	public Account(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount){
		balance += amount;
		System.out.println(Thread.currentThread().getName() + " 当前账户余额为：" + balance);
	}
}
