package thread01.com.atguigu.java;

/*
 * 模拟三个售票窗口，同时卖票100张
 */
public class TestThread3 {
	
	public static void main(String[] args) {
		
/*		Window win1 = new Window();
		win1.setName("1号窗口");
		
		Window win2 = new Window();
		win2.setName("2号窗口");
		
		Window win3 = new Window();
		win3.setName("3号窗口");
		
		win1.start();
		win2.start();
		win3.start();*/
		
		Ticket ticket = new Ticket();
		
		Thread win1 = new Thread(ticket, "1号窗口");
		Thread win2 = new Thread(ticket, "2号窗口");
		Thread win3 = new Thread(ticket, "3号窗口");
		
		win1.start();
		win2.start();
		win3.start();
		
	}

}
