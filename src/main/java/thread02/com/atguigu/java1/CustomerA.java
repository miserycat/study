package thread02.com.atguigu.java1;

public class CustomerA implements Runnable {

	private Account acc;

	public CustomerA(Account acc) {
		this.acc = acc;
	}

	public CustomerA() {
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
				Thread.sleep((int)(Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			acc.deposit(1000);
		}

	}

}
