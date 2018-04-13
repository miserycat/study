package thread02.com.atguigu.exer;

public class Customer implements Runnable {

	private Account acc;

	public Customer(Account acc) {
		this.acc = acc;
	}

	public Customer() {
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
			
			acc.deposit(1000);
		}
	}

}
