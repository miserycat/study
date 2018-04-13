package thread01.com.atguigu.exer;

import java.io.File;

public class HelloThread3 extends Thread{
	
	public void run(){
		HelloThread2 ht2 = new HelloThread2();
		File file = ht2.getFile();
		
		File[] files = file.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			System.out.println("名称：" + files[i].getName());
			System.out.println("大小：" + files[i].length());
		}
	}

}
