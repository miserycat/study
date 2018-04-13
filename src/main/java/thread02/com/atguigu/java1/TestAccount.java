package thread02.com.atguigu.java1;

public class TestAccount {
	
	public static void main(String[] args) {
		Account acc = new Account();
		
		CustomerA cusA = new CustomerA(acc);
		CustomerB cusB = new CustomerB(acc);
		
		new Thread(cusA).start();
		new Thread(cusB).start();
	}

}
