package thread01.com.atguigu.exer;

/*
在main方法中创建并启动一个线程，该线程随机产生100个0-100整数，打印后结束；
在main方法中创建并启动两个线程。第一个线程统计指定目录下的文件个数及所占总空间数并打印输出，
另一个线程打印输出此目录中每个文件信息如文件名称和大小。

 */
public class TestThread {
	
	public static void main(String[] args) {
		
		HelloThread ht = new HelloThread();
		ht.start();
		
		HelloThread2 ht2 = new HelloThread2();
		ht2.start();
		
		new HelloThread3().start();
		
	}

}
