package thread02.com.atguigu.java1;

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

	//存款方法
	public synchronized void deposit(double amount){
		if(balance + amount > 10000){
			System.out.println("账户已满！");
			
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}else{
			balance += amount;
			System.out.println("存款成功，余额为：" + balance);
			
			notify();
		}
	}
	
	//取款方法
	public synchronized void withdraw(double amount){
		if(balance < amount){
			System.out.println("余额不足！");
			
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}else{
			balance -= amount;
			System.out.println("取款成功，余额为：" + balance);
			
			notify();
		}
	}
}
