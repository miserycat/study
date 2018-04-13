package thread02.com.atguigu.exer;

public class TestAccount {
	
	public static void main(String[] args) {
		
		Account acc = new Account();
		
		Customer cus1 = new Customer(acc);
		Customer cus2 = new Customer(acc);
		
		Thread t1 = new Thread(cus1);
		Thread t2 = new Thread(cus2);
		
		t1.start();
		t2.start();
	}

}
