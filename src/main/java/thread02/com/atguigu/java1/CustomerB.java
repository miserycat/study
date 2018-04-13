package thread02.com.atguigu.java1;

public class CustomerB implements Runnable {

	private Account acc;

	public CustomerB() {
	}

	public CustomerB(Account acc) {
		this.acc = acc;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

	@Override
	public void run() {
		while(true){
			
			try {
				Thread.sleep((int)(Math.random() * 50));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			acc.withdraw(1000);
		}
	}

}
