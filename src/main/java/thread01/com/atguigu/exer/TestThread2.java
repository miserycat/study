package thread01.com.atguigu.exer;

/*
 * 在main方法中创建并启动两个线程。第一个线程循环随机打印100以内的整数，直到第二个线程从键盘读取了“Q”命令。
 */
public class TestThread2 {
	
	public static void main(String[] args) {
		
		HelloThread4 ht4 = new HelloThread4();
		Thread t1 = new Thread(ht4);
		t1.start();
		
		HelloThread5 ht5 = new HelloThread5();
		Thread t2 = new Thread(ht5);
		t2.start();
		
	}

}
