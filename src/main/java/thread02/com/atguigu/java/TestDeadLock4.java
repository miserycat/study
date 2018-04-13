package thread02.com.atguigu.java;

public class TestDeadLock4 {
	
	public static void main(String[] args) {
		
		DeadLock dl1 = new DeadLock();
		Thread t1 = new Thread(dl1);
		t1.start();
		
		
		DeadLock dl2 = new DeadLock();
		dl2.flag = false;
		new Thread(dl2).start();
		
	}

}
